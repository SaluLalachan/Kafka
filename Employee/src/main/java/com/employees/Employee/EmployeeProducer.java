package com.employees.Employee;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
@Configuration
public class EmployeeProducer {
    @Bean
    public void setProperties() {
        System.out.println("Producer invoked");
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());

        KafkaProducer<String,AddressDetails> producer=new KafkaProducer<>(properties);
        AddressDetails addressDetails = AddressDetails.newBuilder().setId(1).setHouseName("Aurovilla").
                setStreetName("Elampal").setCity("Punalur").setDistrict("Kollam")
                .setState("Kerala").setCountry("India").setPostCode(691322).build();
        ProducerRecord<String, AddressDetails> record = new ProducerRecord<String, AddressDetails>("AddressDetails",addressDetails.getId().toString(),addressDetails);
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
