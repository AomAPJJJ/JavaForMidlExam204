package sit.int204.testclassicmodelsservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.testclassicmodelsservice.dtos.SimpleEmployeeDTO;
import sit.int204.testclassicmodelsservice.entities.Employee;
import sit.int204.testclassicmodelsservice.repositories.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
//    @Autowired
//    private EmployeeRepository employeeRepository;
//    @Autowired
//    private ModelMapper modelMapper;
//
//
//    public List<SimpleEmployeeDTO> getAllEmployee() {
//        List<Employee> employees = employeeRepository.findAll();
//        return employees.stream()
//                .map(employee -> modelMapper.map(employee, SimpleEmployeeDTO.class))
//                .collect(Collectors.toList());
//    }
//    public Employee save(Employee employee){
//        return employeeRepository.save(employee);
//    }
}
