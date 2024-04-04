package sit.int204.classicmodelsprac.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import sit.int204.classicmodelsprac.entities.Employee;
import sit.int204.classicmodelsprac.entities.Order;

import java.util.List;

@Getter
@Setter

public class SimpleCustomerDTO {

    private String customerName;
    private String phone;
    private String city;
    private String country;



    @JsonIgnore
    private SimpleEmployeeDTO sales;

    public String getSalesPerson() {
        return sales == null ? "-" : sales.getName() + " - " + sales.getOfficeCity();
    }


}
