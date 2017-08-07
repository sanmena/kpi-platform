package platform.domain.Repositories;

import org.springframework.data.repository.CrudRepository;
import platform.domain.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
