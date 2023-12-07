package Services;

import com.employees.Employee.AddressDetails;
import com.employees.Employee.EmployeeDetails;
import com.employees.Employee.PersonalDetails;

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
}
