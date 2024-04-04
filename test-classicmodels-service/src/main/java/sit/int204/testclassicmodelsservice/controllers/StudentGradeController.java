package sit.int204.testclassicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.testclassicmodelsservice.models.Student;
import sit.int204.testclassicmodelsservice.services.StudentGradeService;

@RestController
@RequestMapping("/api/student-grades")
public class StudentGradeController {
    @Autowired
    private StudentGradeService studentGradeService;

    @GetMapping("")
    public Student calculateGrade(@RequestBody Student student){
        return studentGradeService.getGrade(student);
    }
}
