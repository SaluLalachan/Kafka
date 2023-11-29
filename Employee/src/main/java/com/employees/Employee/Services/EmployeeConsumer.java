package com.employees.Employee.Services;

import com.employees.Employee.kafka.avro.model.AddressDetails;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
@Configuration
public class EmployeeConsumer {
    @Bean
        public void setConsumerProperties() {
            System.out.println("Consumer invoked");
            String groupId="employee-data";
            Properties properties = new Properties();
            properties.setProperty("bootstrap.servers","127.0.0.1:9092");
            properties.setProperty("key.deserializer", StringDeserializer.class.getName());
            properties.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
            properties.setProperty("schema.registry.url","http://localhost/8080");
            properties.setProperty("group.id",groupId);

            KafkaConsumer<String,AddressDetails> consumer=new KafkaConsumer<>(properties);
            consumer.subscribe(Arrays.asList("Addressdetails"));
            while(true) {
                System.out.println("polling");
                ConsumerRecords<String, AddressDetails> record = consumer.poll(Duration.ofMillis(1000));
                for(ConsumerRecord<String,AddressDetails> records: record){
                    System.out.println(records.value());
                }
            }
        }
    }


