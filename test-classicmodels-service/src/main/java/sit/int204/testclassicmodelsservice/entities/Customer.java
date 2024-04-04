package sit.int204.testclassicmodelsservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customerNumber", nullable = false, length = 50)
    private Integer id;
    @Column(name = "customerName", nullable = false, length = 50)
    private String customerName;
    @Column(name = "contactLastName", nullable = false, length = 50)
    private String contactLastName;
    @Column(name = "contactFirstName", nullable = false, length = 50)
    private String contactFirstName;
    @Column(name = "phone", length = 50)
    private String phone;
    @Column(name = "addressLine1", length = 50)
    private String addressLine1;
    @Column(name = "addressLine2", nullable = false, length = 50)
    private String city;
    @Column(name = "city", nullable = false, length = 15)
    private String state;
    @Column(name = "postalCode", nullable = false, length = 50)
    private String postalCode;
    @Column(name = "country", nullable = false, length = 50)
    private String country;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employee salesRepEmployee;

    private Double creditLimit;
    @OneToMany(mappedBy = "customerNumber")
    private List<Order> orderList;

    private String password;
    private String role;
}
