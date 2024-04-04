package sit.int204.testclassicmodelsservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    private String orderNumber;
    private String productCode;
    private String quantityOrdered;
    private String priceEach;
    private String orderLineNumber;
}
