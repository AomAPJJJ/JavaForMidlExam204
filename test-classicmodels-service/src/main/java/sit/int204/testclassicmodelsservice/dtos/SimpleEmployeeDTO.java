package sit.int204.testclassicmodelsservice.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SimpleEmployeeDTO {
    private String firstname;
    private String lastname;
    private String officeCity; // เอา city ของ office
    public String getName() {
        return firstname + ' ' + lastname;
    }
}
