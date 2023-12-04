package com.employees.Employee.Services;

import com.employees.Employee.kafka.avro.model.AddressDetails;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
//import org.apache.kafka.streams.StreamsBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Service
public class EmployeeProducer {
    public static void sendMessage(AddressDetails addressDetails) {
       System.out.println("Producer invoked");
       Properties properties = new Properties();
       properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
       properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
       properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
       properties.setProperty("schema.registry.url", "http://localhost/8081/");
       KafkaProducer<String, AddressDetails> producer = new KafkaProducer<>(properties);

//        AddressDetails addressDetails = AddressDetails.newBuilder().setId(1).setHouseName("Aurovilla").
//                setStreetName("Elampal").setCity("Punalur").setPostCode(691322).setDistrict("Kollam")
////                .setState("Kerala").setCountry("India").build();
      ProducerRecord<String, AddressDetails> record = new ProducerRecord<String, AddressDetails>("Addressabc", addressDetails.getId().toString(), addressDetails);
        //System.out.println("record created");
       producer.send(record);
//        producer.send(record);
//       producer.flush();
        producer.close();
    }


    }

