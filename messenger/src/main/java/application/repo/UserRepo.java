package application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
