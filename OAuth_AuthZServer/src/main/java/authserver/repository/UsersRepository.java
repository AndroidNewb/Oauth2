package authserver.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import authserver.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
    
    Users findOneByName(String username);
    
}
