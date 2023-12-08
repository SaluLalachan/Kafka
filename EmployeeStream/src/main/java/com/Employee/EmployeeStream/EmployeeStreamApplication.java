package com.Employee.EmployeeStream;

import Services.EmployeeServices;
import org.apache.kafka.streams.KafkaStreams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class EmployeeStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeStreamApplication.class, args);
		EmployeeServices employeeServices= new EmployeeServices();
		Properties properties;
		properties = employeeServices.employeeStreamMethod();
		KafkaStreams kafkaStreams= employeeServices.setStreamProperties();
	}

}
