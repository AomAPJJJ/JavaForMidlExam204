package sit.int204.testclassicmodelsservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "orderNumber", nullable = false, length = 10)
    private String orderNumber;
    @Column(name = "orderDate", nullable = false, length = 50)
    private String orderDate;
    @Column(name = "requiredDate", nullable = false, length = 50)
    private String requiredDate;
    @Column(name = "shippedDate", nullable = false, length = 50)
    private String shippedDate;
    @Column(name = "status", length = 50)
    private String status;
    @Column(name = "comments", length = 50)
    private String comments;
    @Column(name = "customerNumber", nullable = false, length = 50)
    private String customerNumber;
}
