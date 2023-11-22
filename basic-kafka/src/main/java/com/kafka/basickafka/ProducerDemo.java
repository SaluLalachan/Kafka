package com.kafka.basickafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class ProducerDemo {

	public static void main(String[] args) {
		SpringApplication.run(ProducerDemo.class, args);
		//System.out.println("Hellow Java");

	}

}
