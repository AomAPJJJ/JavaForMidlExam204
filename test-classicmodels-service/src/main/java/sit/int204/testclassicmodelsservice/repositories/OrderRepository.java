package sit.int204.testclassicmodelsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.testclassicmodelsservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}
