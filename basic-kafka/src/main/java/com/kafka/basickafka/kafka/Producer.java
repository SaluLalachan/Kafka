package com.kafka.basickafka.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class Producer {
	public static void main(String args[]) {
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers","127.0.0.1:9092");

		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());

		KafkaProducer<String,String> producer= new KafkaProducer<>(properties);
		for (int i = 0; i <20 ; i++) {
			ProducerRecord<String,String> producerRecord= new ProducerRecord<>("demo_java","hello "+ i);
			producer.send(producerRecord);
		}


		producer.flush();
		producer.close();



	}
}
