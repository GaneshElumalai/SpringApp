package application.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Reaction")
public class Reaction {
	
	@Id
	private long id;
	@EmbeddedId
	private Message message;
	private String reactedBy;
	private ReactionType reactionType;
	private Date reactedDate;
	
}
