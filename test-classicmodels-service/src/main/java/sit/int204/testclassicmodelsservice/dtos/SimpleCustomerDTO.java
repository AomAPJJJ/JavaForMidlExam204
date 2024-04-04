package sit.int204.testclassicmodelsservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import sit.int204.testclassicmodelsservice.entities.Employee;

@Getter
@Setter
public class SimpleCustomerDTO {
    private String customerName;
    private String phone;
    private String city;
    private String country;
    @JsonIgnore // ไม่ให้แปลงเป็น JSON
    private SimpleEmployeeDTO salesRepEmployee;
    public String getSalePerson() {
        return salesRepEmployee == null ? "-" : salesRepEmployee.getName()
                + ' ' + salesRepEmployee.getOfficeCity();
    }

//    private Employee salesPerson;
//    private String salesOfficeCity;
//    private String salesFirstname;
}
