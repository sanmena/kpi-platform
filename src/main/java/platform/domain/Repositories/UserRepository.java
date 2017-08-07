package platform.domain.Repositories;


import org.springframework.data.repository.CrudRepository;
import platform.domain.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findFirstByName(String name);

}
