package com.employees.Employee.Services.Producer;

import com.employees.Employee.kafka.avro.model.AddressDetails;
import com.employees.Employee.kafka.avro.model.PersonalDetails;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.ExecutionException;


@Service
public class ProducerInfo {

    private static final Logger log = LoggerFactory.getLogger(ProducerInfo.class);

    public static void sendInfo(PersonalDetails personalDetails) {
        System.out.println("Producer invoked");

       Properties properties = new Properties();
       properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
       properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
       properties.put("schema.registry.url", "http://localhost:8081");
            KafkaProducer<String, PersonalDetails> producer = new KafkaProducer<>(properties);
        //System.out.println("printing producer before" + addressDetails);
        PersonalDetails personaldetails = PersonalDetails.newBuilder().setId(personalDetails.getId()).setName(personalDetails.getName())
                .setLastName(personalDetails.getName()).setAge(personalDetails.getAge()).setSex(personalDetails.getSex()).build();
        ProducerRecord<String, PersonalDetails> record = new ProducerRecord<>
                ("Personaldetails", personalDetails.getId().toString(), personalDetails);
        try {
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                    if (exception == null) {
                        System.out.println("Personal Record sent successfully");
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

