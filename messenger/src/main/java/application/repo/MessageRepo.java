package application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
}
