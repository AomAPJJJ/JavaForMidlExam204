package sit.int204.testclassicmodelsservice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.testclassicmodelsservice.dtos.SimpleEmployeeDTO;
import sit.int204.testclassicmodelsservice.entities.Employee;
import sit.int204.testclassicmodelsservice.services.EmployeeService;
import sit.int204.testclassicmodelsservice.services.ListMapper;
import sit.int204.testclassicmodelsservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
//    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    private ListMapper listMapper;

//    @PostMapping("")
//    public Employee create(@RequestBody SimpleEmployeeDTO employeeDTO){
//        Employee employee = modelMapper.map(employeeDTO, Employee.class);
//        return employeeService.save((employee));
//    }
}
