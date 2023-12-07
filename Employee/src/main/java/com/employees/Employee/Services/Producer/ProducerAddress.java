package com.employees.Employee.Services.Producer;

import com.employees.Employee.kafka.avro.model.AddressDetails;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
//import org.apache.kafka.streams.StreamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.ExecutionException;


@Service
public class ProducerAddress {

    private static final Logger log = LoggerFactory.getLogger(ProducerAddress.class);

    public static void sendMessage(AddressDetails addressDetails) {
        System.out.println("Producer invoked");

       Properties properties = new Properties();
       properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
       properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
       properties.put("schema.registry.url", "http://localhost:8081");
            KafkaProducer<String, AddressDetails> producer = new KafkaProducer<>(properties);
        //System.out.println("printing producer before" + addressDetails);
        AddressDetails addressdetails = AddressDetails.newBuilder().setId(addressDetails.getId()).setHouseName(addressDetails.getHouseName()).
               setStreetName(addressDetails.getStreetName()).setCity(addressDetails.getCity()).setPostCode(addressDetails.getPostCode()).
                setDistrict(addressDetails.getDistrict()).setState(addressDetails.getState()).setCountry(addressDetails.getCountry()).build();
        ProducerRecord<String, AddressDetails> record = new ProducerRecord<>
                ("addressdetails", addressDetails.getId().toString(), addressDetails);
        try {
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                    if (exception == null) {
                        System.out.println("Address Record sent successfully");
                        log.info(String.valueOf(record));
                    } else {
                        System.out.println("Error while sending record");
                    }
                }
            }).get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        producer.flush();
        producer.close();
    }


}

