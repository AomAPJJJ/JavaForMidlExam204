package sit.int204.classicmodelsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
}
