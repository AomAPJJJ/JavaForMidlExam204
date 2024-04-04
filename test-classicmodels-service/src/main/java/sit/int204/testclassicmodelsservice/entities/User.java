package sit.int204.testclassicmodelsservice.entities;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity
@Table(name = "users")
// test
public class User {
    @Id
    private Integer userId;
    private String name;
    private String password;
}
