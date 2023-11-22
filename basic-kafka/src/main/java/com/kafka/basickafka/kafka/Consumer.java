package com.kafka.basickafka.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {
        String groupId="my-java-application";
        String topic="demo_java";

        Properties properties= new Properties();
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer",StringDeserializer.class.getName());

        properties.setProperty("group.id",groupId);
        properties.setProperty("auto.offset.reset","earliest");

        KafkaConsumer<String,String> consumer= new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(topic));
        while(true){
            //System.out.println("polling");
            ConsumerRecords<String,String> records= consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<String,String> record:records){
                System.out.println(record.value());
            }
        }
    }

}
