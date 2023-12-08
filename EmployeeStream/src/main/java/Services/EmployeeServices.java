package Services;


import com.employees.Employee.kafka.avro.model.AddressDetails;
import com.employees.Employee.kafka.avro.model.EmployeeDetails;
import com.employees.Employee.kafka.avro.model.PersonalDetails;
import com.employees.Employee.kafka.avro.model.VehicleDetails;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Properties;

import static java.util.Collections.singletonMap;

@Configuration
public class EmployeeServices {

    private SpecificAvroSerde<AddressDetails> addressDetailsSpecificAvroSerde;
    private SpecificAvroSerde<PersonalDetails> personalDetailsSpecificAvroSerde;
    private SpecificAvroSerde<VehicleDetails> vehicleDetailsSpecificAvroSerde;
    private SpecificAvroSerde<EmployeeDetails> employeeDetailsSpecificAvroSerde;

    public EmployeeServices() {
        System.out.println("Constructor invoked");
        this.addressDetailsSpecificAvroSerde = addressDetailsSpecificAvroSerde;
        this.personalDetailsSpecificAvroSerde = personalDetailsSpecificAvroSerde;
        this.employeeDetailsSpecificAvroSerde = employeeDetailsSpecificAvroSerde;
        this.personalDetailsSpecificAvroSerde = personalDetailsSpecificAvroSerde;

    }

     @Bean
    public Properties employeeStreamMethod() {

         System.out.println("set properties invoked");
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream-join");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class.getName());
        properties.put("schema.registry.url", "http://localhost:8081");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }
    @Bean
    public KafkaStreams setStreamProperties() {
        System.out.println("Stream invokde");
        StreamsBuilder builder = new StreamsBuilder();

        Properties properties= employeeStreamMethod();
        // = buildTopology(new StreamsBuilder(),singletonMap(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081"));
      //  final KafkaStreams streams = new KafkaStreams(topology, streamsConfiguration);

        KStream<String, AddressDetails> address = builder.stream("addressdetails", Consumed.with(Serdes.String(), addressDetailsSpecificAvroSerde));
        KStream<String, PersonalDetails> personal = builder.stream("Personaldetails", Consumed.with(Serdes.String(), personalDetailsSpecificAvroSerde));
        KStream<String, VehicleDetails> vehicle = builder.stream("vehicledetails", Consumed.with(Serdes.String(), vehicleDetailsSpecificAvroSerde));



        KStream<Integer, EmployeeDetails> addressDetailsPersonalDetailsKStream = address.outerJoin(personal,
//                (personalDetails, addressDetails) -> employeeAdd(addressDetails, personalDetails),
                        EmployeeAdd::employeeadd,
                        JoinWindows.of(Duration.ofMinutes(1)))
                // , Joined.with(Serdes.String(), personalDetailsSpecificAvroSerde, addressDetailsSpecificAvroSerde))
                .selectKey((k, v) -> v.getId()).groupByKey().aggregate(EmployeeDetails::new,(aggregateKey,oldValue,newValue)->
                        EmployeeAdd.setAggregate(oldValue,newValue), Materialized.as("employee-store")).toStream();

//        Topology topology=builder.build();
//        KafkaStreams streams = new KafkaStreams(topology, properties);
//        streams.start();
        // Build the Topology
        Topology topology = builder.build();

// Create KafkaStreams instance
        KafkaStreams streams = new KafkaStreams(topology, properties);

// Start the KafkaStreams application
        streams.start();

        addressDetailsPersonalDetailsKStream.print(Printed.<Integer,EmployeeDetails>toSysOut());
        return streams;
    }

}
