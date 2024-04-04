package sit.int204.testclassicmodelsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.testclassicmodelsservice.entities.CustomerTwo;

import java.util.List;

public interface CustomerTwoRepository extends JpaRepository<CustomerTwo, Long> {
    List<CustomerTwo> findByFirstnameContains(String firstname);
}
