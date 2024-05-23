package sit.int204.classicmodelsservice.entities;

import jakarta.persistence.*;
import lombok.*;
    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Customera {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(name = "first_name")
        private String firstName;
        private String lastName;
    }

