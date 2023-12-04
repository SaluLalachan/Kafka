package com.employees.Employee.Controller;

import com.employees.Employee.Services.EmployeeProducer;
import com.employees.Employee.kafka.avro.model.AddressDetails;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("employee/kafka")
public class EmployeeController {
    EmployeeProducer employeeProducer;

    public EmployeeController(EmployeeProducer employeeProducer) {
        this.employeeProducer = employeeProducer;
    }

    @PostMapping("/publish")
    public void sendDetails(@RequestBody AddressDetails addressDetails) throws ExecutionException, InterruptedException {
        EmployeeProducer.sendMessage(addressDetails);
//        System.out.println(addressDetails);
//        return addressDetails.toString();
    }
    @PostMapping("/check")
    public String sendDetails(@RequestParam String message) {
        //EmployeeProducer.sendMessage(message);
        return message;
    }
}

