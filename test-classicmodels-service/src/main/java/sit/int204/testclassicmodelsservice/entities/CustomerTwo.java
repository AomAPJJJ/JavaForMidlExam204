package sit.int204.testclassicmodelsservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerTwo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstname;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastname;
}
