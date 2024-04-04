package sit.int204.testclassicmodelsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.testclassicmodelsservice.entities.Office;

public interface OfficeRepository extends JpaRepository<Office,String> {
}
