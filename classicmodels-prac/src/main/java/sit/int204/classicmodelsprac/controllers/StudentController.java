package sit.int204.classicmodelsprac.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.classicmodelsprac.entities.Office;
import sit.int204.classicmodelsprac.entities.Student;
import sit.int204.classicmodelsprac.services.OfficeService;
import sit.int204.classicmodelsprac.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student-grades")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("")
    public Student getGrade(@RequestBody Student student){
        return  service.getGrades(student);
    }




}
