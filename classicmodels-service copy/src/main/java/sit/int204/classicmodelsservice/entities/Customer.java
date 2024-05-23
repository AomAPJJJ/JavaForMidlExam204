package sit.int204.classicmodelsservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Integer customerNumber;
    private String contactFirstName;
    private String contactLastName;
    private String customerName;
    private String addressLine2;
    private String addressLine1;
    private String phone;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber")
    private  Employees salesRepEmployee;

    private Double creditLimit;
    @OneToMany(mappedBy = "customerNumber")
    private List<Order> orderList;

    private String password;
    private String role;
}
