package com.employees.Employee.Services.Consumer;

import com.employees.Employee.kafka.avro.model.AddressDetails;
import com.employees.Employee.kafka.avro.model.PersonalDetails;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Joined;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.ValueJoiner;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
public class ConsumerAddress {
    public static void main(String[] args) {
        System.out.println("Consumer invoked");
        String groupId = "employee-data";
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaDataConsumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        // Set up Avro deserializer configs
        props.put("schema.registry.url", "http://localhost:8081");
        KafkaConsumer<String, AddressDetails> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("addressdetails", "Personaldetails", "vehicledetails"));

//
//            ValueJoiner<String,AddressDetails,PersonalDetails> valueJoiner=(v1,v2)->{return v1+String.valueOf(v2);};
//            KStream<String,String> addressInfoOuterJoin = address.outerJoin(personal,(v1,v2)-> {
//           }, Joined.with(Serdes.String(),addressDetailsSpecificAvroSerde,personalDetailsSpecificAvroSerde));

        while (true) {
            System.out.println("polling");
            ConsumerRecords<String, AddressDetails> record = consumer.poll(Duration.ofMillis(1000));

            for (ConsumerRecord<String, AddressDetails> records : record) {
                System.out.println("Consumer code" + records.value());
            }
        }
    }
}



