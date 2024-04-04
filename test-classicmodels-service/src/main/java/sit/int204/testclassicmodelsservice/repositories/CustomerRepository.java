package sit.int204.testclassicmodelsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.testclassicmodelsservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
