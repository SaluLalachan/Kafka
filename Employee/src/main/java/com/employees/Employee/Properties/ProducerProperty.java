package com.employees.Employee.Properties;

import com.employees.Employee.kafka.avro.model.AddressDetails;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

public class ProducerProperty {
   // @Bean(name = "Address")
    public KafkaProducer<String, AddressDetails> setproducerProperties() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://localhost/8080/");
        return new KafkaProducer<>(properties);
    }
}
