package sit.int204.classicmodelsservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NewSimpleEmployeeDto {
    @NotEmpty
    private Integer id;
    @NotEmpty
    private String lastName;
    @JsonIgnore
    private String firstName;
    @JsonIgnore
    private String officeCity;
    public String getFullName() {
        return firstName + ' ' + lastName;
    } // ได้เป็น filed ของ method
}
