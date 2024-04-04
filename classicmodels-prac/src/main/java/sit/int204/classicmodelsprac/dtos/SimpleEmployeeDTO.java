package sit.int204.classicmodelsprac.dtos;

import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimpleEmployeeDTO {
    private String lastName;
    private String firstName;
    public String officeCity;

    public  String getName(){
        return  firstName + ' ' + lastName;
    }


}