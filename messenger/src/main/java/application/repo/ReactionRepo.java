package application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entity.Reaction;

public interface ReactionRepo extends JpaRepository<Reaction, Long> {
	public List<Reaction> findByMessageId(long id);
	public Reaction findByMessageIdAndUserId(long msgId,long userId);
}
