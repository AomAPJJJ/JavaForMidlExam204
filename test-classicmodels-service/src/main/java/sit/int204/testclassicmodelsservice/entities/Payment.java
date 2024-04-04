package sit.int204.testclassicmodelsservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    private String customerNumber;
    private String checkNumber;
    private String paymentDate;
    private String amount;
}
