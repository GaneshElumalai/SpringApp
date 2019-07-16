package application.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="APP_MESSAGE", uniqueConstraints=@UniqueConstraint(columnNames={"MsgID","Message"}))
@Embeddable
public class Message implements Serializable {
	
	private static final long serialVersionUID=2L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false, name="MsgID", length=5000)
	private long messageId;
	@Column(nullable=false, name="Message", length=5000)
	private String message;
	@Column(nullable=false, name="Author", length=100)
	private String author;
	@Column(nullable=false, name="Created_Date")
	private Date created_date;
	@Column(nullable=true, name="Updated_Date")
	private Date updated_date;
	@Column(nullable=true, name="Updated_By")
	private String updated_by;
	@Column(nullable=false, name="Deleted")
	private char isDeleted;
	
	public Message(){
	}
	
	public Message(String message, String author, Date created_date, Date updated_date,
			String updated_by) {
		super();
		this.message = message;
		this.author = author;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.updated_by = updated_by;
		this.isDeleted = 'N';
	}
	
	public Message(String message, String author) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.author = author;
		this.created_date = new Date();
		this.updated_date = null;
		this.updated_by = null;
		this.isDeleted = 'N';
	}
	
	
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public char isDeleted() {
		return isDeleted ;
	}
	public void setDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + ", author=" + author + ", created_date="
				+ created_date + ", updated_date=" + updated_date + ", updated_by=" + updated_by + ", isDeleted="
				+ isDeleted + "]";
	}
	
	
	
}
