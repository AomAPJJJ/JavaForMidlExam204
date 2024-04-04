package sit.int204.testclassicmodelsservice.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.testclassicmodelsservice.models.Student;

@Service
public class StudentGradeService {
    public Student getGrade(Student student){
        if (student.getScore() == null || student.getScore() > 100 || student.getScore() < 0) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Invalid score : (" + student.getScore() + ")");
        }
        student.calculateGrade();
        return student;
    }
}
