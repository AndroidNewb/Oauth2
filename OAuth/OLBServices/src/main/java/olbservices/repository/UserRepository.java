package olbservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import olbservices.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByusername(String username);
}
