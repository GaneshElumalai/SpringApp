package application.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Reaction")
public class Reaction {
	
	@Id
	@GeneratedValue
	private long id;
	private String reactedBy;
	private ReactionType reactionType;
	private Date reactedDate;
	
	@ManyToOne(targetEntity = Message.class)
	@JoinColumn(name = "FK_MSG_ID")
	@JsonIgnore
	private Message reactedMessage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReactedBy() {
		return reactedBy;
	}

	public void setReactedBy(String reactedBy) {
		this.reactedBy = reactedBy;
	}

	public ReactionType getReactionType() {
		return reactionType;
	}

	public void setReactionType(ReactionType reactionType) {
		this.reactionType = reactionType;
	}

	public Date getReactedDate() {
		return reactedDate;
	}

	public void setReactedDate(Date reactedDate) {
		this.reactedDate = reactedDate;
	}

	public Message getReactedMessage() {
		return reactedMessage;
	}

	public void setReactedMessage(Message reactedMessage) {
		this.reactedMessage = reactedMessage;
	}
	
	
	
}
