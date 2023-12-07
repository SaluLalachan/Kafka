package Services;

import com.employees.Employee.AddressDetails;
import com.employees.Employee.EmployeeDetails;
import com.employees.Employee.PersonalDetails;
import com.employees.Employee.VehicleDetails;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.Joined;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Properties;

//@Configuration
public class EmployeeServices {

    // @Bean
    public void employeeStreamMethod() {

        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put("schema.registry.url", "http://localhost:8081");

        StreamsBuilder builder = new StreamsBuilder();

        SpecificAvroSerde<AddressDetails> addressDetailsSpecificAvroSerde = new SpecificAvroSerde<>();
        SpecificAvroSerde<PersonalDetails> personalDetailsSpecificAvroSerde = new SpecificAvroSerde<>();
        SpecificAvroSerde<VehicleDetails> vehicleDetailsSpecificAvroSerde = new SpecificAvroSerde<>();
        SpecificAvroSerde<EmployeeDetails> employeeDetailsSpecificAvroSerde = new SpecificAvroSerde<>();

        KStream<String, AddressDetails> address = builder.stream("addressdetails", Consumed.with(Serdes.String(), addressDetailsSpecificAvroSerde));
        KStream<String, PersonalDetails> personal = builder.stream("Personaldetails", Consumed.with(Serdes.String(), personalDetailsSpecificAvroSerde));
        KStream<String, VehicleDetails> vehicle = builder.stream("vehicledetails", Consumed.with(Serdes.String(), vehicleDetailsSpecificAvroSerde));

        KStream<String, EmployeeDetails> addressDetailsPersonalDetailsKStream = personal.outerJoin(address,
//                (personalDetails, addressDetails) -> employeeAdd(addressDetails, personalDetails),
                EmployeeAdd::employeeadd,
                JoinWindows.of(Duration.ofMinutes(1)))
              // , Joined.with(Serdes.String(), personalDetailsSpecificAvroSerde, addressDetailsSpecificAvroSerde))
                .selectKey((k,v) ->v.getId()).groupByKey().toStream();

        KafkaStreams streams = new KafkaStreams(builder.build(), properties);
        streams.start();
    }

//    public static EmployeeDetails employeeAdd(AddressDetails addressDetails, PersonalDetails personalDetails) {
//        EmployeeDetails employeeDetails = new EmployeeDetails();
//        if (addressDetails == null) {
//            if (personalDetails != null) {
//                employeeDetails.newBuilder()
//                        .setId(personalDetails.getId())
//                        .setName(personalDetails.getName())
//                        .setLastName(personalDetails.getLastName())
//                        .setAge(personalDetails.getAge())
//                        .setSex(personalDetails.getSex())
//                        .build();
//            }
//        } else {
//            employeeDetails.newBuilder()
//                    .setId(addressDetails.getId())
//                    .setHouseName(addressDetails.getHouseName())
//                    .setStreetName(addressDetails.getStreetName())
//                    .setCity(addressDetails.getCity())
//                    .setPostCode(addressDetails.getPostCode())
//                    .setDistrict(addressDetails.getDistrict())
//                    .setState(addressDetails.getState())
//                    .setCountry(addressDetails.getCountry())
//                    .setName(personalDetails.getName())
//                    .setLastName(personalDetails.getLastName())
//                    .setAge(personalDetails.getAge())
//                    .setSex(personalDetails.getSex())
//                    .build();
//        }
//
//        return employeeDetails;
//    }
}
