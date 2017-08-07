package platform.domain.Repositories;

import org.springframework.data.repository.CrudRepository;
import platform.domain.entities.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
