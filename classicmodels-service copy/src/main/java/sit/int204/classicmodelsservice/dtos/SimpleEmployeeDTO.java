package sit.int204.classicmodelsservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleEmployeeDTO {
    private String lastName;
    private String firstName;
    private String officeCity;
    public String getFullName(){
        return firstName + ' ' + lastName;
    } // ได้เป็น filed ของ method
}
