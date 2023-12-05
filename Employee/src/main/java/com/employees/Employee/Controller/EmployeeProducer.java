package com.employees.Employee.Services;

import com.employees.Employee.kafka.avro.model.AddressDetails;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
//import org.apache.kafka.streams.StreamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
public class EmployeeProducer {

    private static final Logger log = LoggerFactory.getLogger(EmployeeProducer.class);

    public void sendMessage(AddressDetails addressDetails) {
        System.out.println("Producer invoked");

       Properties properties = new Properties();
       properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
       properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
       properties.put("schema.registry.url", "http://localhost:8081");
        properties.put("basic.auth.credentials.source", "USER_INFO");
        properties.put("schema.registry.basic.auth.user.info", "USER NAME:PASSWORD");
            KafkaProducer<String, AddressDetails> producer = new KafkaProducer<>(properties);
        System.out.println("printing producer before" + addressDetails);
        AddressDetails addressdetails = AddressDetails.newBuilder().setId(addressDetails.getId()).setHouseName(addressDetails.getHouseName()).
                setStreetName(addressDetails.getStreetName()).setCity(addressDetails.getCity()).setPostCode(addressDetails.getPostCode()).
                setDistrict(addressDetails.getDistrict()).setState(addressDetails.getState()).setCountry(addressDetails.getCountry()).build();
        ProducerRecord<String, AddressDetails> record = new ProducerRecord<>
                ("mynewtopic", addressDetails.getId().toString(), addressDetails);
         producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                if (exception == null) {
                    System.out.println("Record sent successfully");
                    //System.out.println(metadata.toString());
                    log.info(String.valueOf(record));
                }else {
                    System.out.println("Error while sending record");
                }
            }
              });

       producer.flush();
        producer.close();
    }


}

