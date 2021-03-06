package org.programmingSeacrh.Hibernate.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@Entity(name="USER_DETAILS")
@Entity	
@Table(name="USER_DETAILS")
public class UserDetails {
	//To treat the userid as primaryKey
	
	
	//@Column(name="user_id")
	@Id@GeneratedValue
	private int userId;
	
	//This wiil skip the username for adding i,e use 	@Transient

	private String userName;
	
	//if you want to save the date but not the time
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	private String address;
	
	//Large Object
	@Lob
	private String description;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//@Column(name="user_name") if you want to use on getter remoce the @Column from rest of the variables
	//eg.g from ID
	public String getUserName() {
		return userName;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Embedded
	private Address useraddress;


	public Address getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(Address useraddress) {
		this.useraddress = useraddress;
	}
	
	
}
