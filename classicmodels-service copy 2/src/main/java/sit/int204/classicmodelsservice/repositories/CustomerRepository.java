package sit.int204.classicmodelsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.entities.Employees;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c where concat(c.contactFirstName,' ',c.contactLastName) = :name")
    Customer findByName(String name);
}
