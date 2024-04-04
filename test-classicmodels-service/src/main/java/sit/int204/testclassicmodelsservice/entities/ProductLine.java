package sit.int204.testclassicmodelsservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productlines")
public class ProductLine {
    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;
}
