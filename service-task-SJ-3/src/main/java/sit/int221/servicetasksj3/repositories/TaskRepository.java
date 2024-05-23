package sit.int221.servicetasksj3.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sit.int221.servicetasksj3.entities.Task;
import sit.int221.servicetasksj3.entities.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.status.id = :newId WHERE t.status.id = :oldId")
    void updateStatusId(Integer oldId, Integer newId);

    List<Task> findByStatus(TaskStatus status);

    @Query("SELECT t FROM Task t WHERE t.status.name IN :filterStatuses")
    List<Task> findTasksByStatus(@Param("filterStatuses") String[] filterStatuses, Sort sort);
}
