package sit.int204.classicmodelsprac.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String firstName;
    private String lastName;
}
