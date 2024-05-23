package sit.int204.classicmodelsservice.models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    @Id
    private Integer id;
    private String name;
    private Integer score;
    private String grade;
    public Student calculateGrade(){
        if (score >= 80) {
            this.grade = "A";
        } else if (score <= 79 || score >= 70) {
            this.grade = "B";
        } else if (score <= 69 || score >= 60) {
            this.grade = "C";
        } else if (score <= 59 || score >= 50) {
            this.grade = "D";
        } else if (score <= 49) {
            this.grade = "F";
        }
        return this;
    }
}
