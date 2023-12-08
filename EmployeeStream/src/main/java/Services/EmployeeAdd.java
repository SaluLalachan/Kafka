package Services;


import com.employees.Employee.kafka.avro.model.AddressDetails;
import com.employees.Employee.kafka.avro.model.EmployeeDetails;
import com.employees.Employee.kafka.avro.model.PersonalDetails;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeAdd {
    public static EmployeeDetails employeeadd(AddressDetails addressDetails, PersonalDetails personalDetails) {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        if (addressDetails != null) {
            EmployeeDetails.newBuilder().setId(addressDetails.getId()).setHouseName(addressDetails.getHouseName()).setStreetName(addressDetails.getStreetName())
                    .setCity(addressDetails.getCity()).setPostCode(addressDetails.getPostCode()).setDistrict(addressDetails.getDistrict())
                    .setState(addressDetails.getState()).setCountry(addressDetails.getCountry()).build();
        }
        if(personalDetails!=null) {
            EmployeeDetails.newBuilder().setName(personalDetails.getName()).setLastName(personalDetails.getLastName())
                    .setAge(personalDetails.getAge()).setSex(personalDetails.getSex()).build();
        }

        return employeeDetails;
    }
    public static EmployeeDetails setAggregate(EmployeeDetails oldValue, EmployeeDetails newValue) {
        oldValue.setId(newValue.getId());
        oldValue.setName(newValue.getName());
        oldValue.setLastName(newValue.getLastName());
        oldValue.setAge(newValue.getAge());
        oldValue.setSex(newValue.getSex());
        oldValue.setHouseName(newValue.getHouseName());
        oldValue.setStreetName(newValue.getStreetName());
        oldValue.setCity(newValue.getCity());
        oldValue.setPostCode(newValue.getPostCode());
        oldValue.setDistrict(newValue.getDistrict());
        oldValue.setState(newValue.getState());
        oldValue.setCountry(newValue.getCountry());
        return oldValue;
    }
}
