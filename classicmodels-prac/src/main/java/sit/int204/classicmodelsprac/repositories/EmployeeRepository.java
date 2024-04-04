package sit.int204.classicmodelsprac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsprac.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
