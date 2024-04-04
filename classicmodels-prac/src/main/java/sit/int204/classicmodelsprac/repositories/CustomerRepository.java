package sit.int204.classicmodelsprac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsprac.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
