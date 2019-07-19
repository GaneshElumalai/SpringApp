package application.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="APP_MESSAGE"
//		, uniqueConstraints=@UniqueConstraint(columnNames={"MsgID","Message"})
		)
@JsonIgnoreProperties(value={"created_date","updated_date"})
public class Message implements Serializable {
	
	private static final long serialVersionUID=2L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false, name="MsgID", length=5000)
	private long messageId;
	
	@Column(nullable=false, name="Message", length=5000)
	private String message;
	@Column(nullable=false, name="Created_Date")
	private Date created_date;
	@Column(nullable=true, name="Updated_Date")
	private Date updated_date;
	@Column(nullable=false, name="Deleted")
	private char isDeleted;
	@ManyToOne(targetEntity=User.class,fetch=FetchType.EAGER)
	@JoinColumn(name="FK_USER_ID",nullable=false)
	private User msgUser;
	
	public User getMsgUser() {
		return msgUser;
	}

	public void setMsgUser(User msgUser) {
		this.msgUser = msgUser;
	}

	public Message(){
	}
	
	public Message(String message, String author, Date created_date, Date updated_date,
			String updated_by) {
		super();
		this.message = message;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.isDeleted = 'N';
	}
	
	public Message(String message, String author) {
		super();
		this.message = message;
		this.created_date = new Date();
		this.updated_date = null;
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
	public char isDeleted() {
		return isDeleted ;
	}
	public void setDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + "]";
	}
	
	
	
}
