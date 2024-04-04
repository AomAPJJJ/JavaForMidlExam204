package sit.int204.classicmodelsprac.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsprac.entities.Student;

@Service
public class StudentService {
 public Student getGrades(Student student){
     if(student.getScore() == null || student.getScore() > 100 || student.getScore() < 0){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                 "Invalid Score (" + student.getScore() + " ) !!! ");

     }

     return student.calculateGrade();
 }

}
