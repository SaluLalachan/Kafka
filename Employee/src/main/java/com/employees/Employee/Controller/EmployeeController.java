package com.employees.Employee.Controller;

import com.employees.Employee.Services.Producer.ProducerAddress;
import com.employees.Employee.Services.Producer.ProducerInfo;
import com.employees.Employee.Services.Producer.ProducerVehicle;
import com.employees.Employee.kafka.avro.model.AddressDetails;
import com.employees.Employee.kafka.avro.model.PersonalDetails;
import com.employees.Employee.kafka.avro.model.VehicleDetails;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("employee/kafka")
public class EmployeeController {
    ProducerAddress employeeProducer;

    public EmployeeController(ProducerAddress employeeProducer) {
        this.employeeProducer = employeeProducer;
    }

    @PostMapping("/publish")
    public void sendDetails(@RequestBody AddressDetails addressDetails) throws ExecutionException, InterruptedException {
        ProducerAddress.sendMessage(addressDetails);
    }
    @PostMapping("/personal")
    public void sendPersonalInfo(@RequestBody PersonalDetails personalDetails) throws ExecutionException, InterruptedException {
        ProducerInfo.sendInfo(personalDetails);
    }
    @PostMapping("/vehicle")
    public void sendVehicleDetails(@RequestBody VehicleDetails vehicleDetails) throws ExecutionException, InterruptedException {
        ProducerVehicle.sendVehicle(vehicleDetails);
    }
    @PostMapping("/check")
    public String sendDetails(@RequestParam String message) {
        //ProducerAddress.sendMessage(message);
        return message;
    }
}

