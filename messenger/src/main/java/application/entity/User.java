package application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="APP_USER",uniqueConstraints=@UniqueConstraint(columnNames={"USER_ID","USER_NAME"}))
public class User {
	@Id
	@Column(name="USER_ID")
	private long id;
	@Column(name="FIRST_NAME",nullable=false)
	private String firstName;
	@Column(name="LAST_NAME",nullable=true)
	private String lastName;
	@Column(name="MAIL_ID",nullable=false)
	private String mailId;
	@Column(name="PASSWORD",nullable=false)
	private String password;
	@Column(name="USER_NAME",nullable=false)
	private String userName;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
