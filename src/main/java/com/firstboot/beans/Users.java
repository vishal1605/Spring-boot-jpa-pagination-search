package com.firstboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users_details")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)   //it give for auto increament and auto generation of id
	private int uId;
	
	@Column(name = "username", columnDefinition = "varchar(500)") // it uses for give column name and Default is--> columnDefinition = "varchar(500) default 0 and ' ' "
	@JsonIgnore
	private String userName;
	
	@Column(nullable = false, unique = true)  // columnDefinition = "BIGINT(20) default 0"
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, length = 300)
	private String city;
	
	@Column(columnDefinition = "DECIMAL(7,2)", nullable = false)  //it uses for Decimal digits
	private double salary;
	
	@Column(name="register_time", nullable = false)
	private String date;
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Users(int uId, String userName, String email, String password, String city, double salary, String date) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.city = city;
		this.salary = salary;
		this.date = date;
	}
	public Users(String userName, String email, String password, String city, double salary, String date) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.city = city;
		this.salary = salary;
		this.date = date;
	}
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [uId=" + uId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", city=" + city + ", salary=" + salary + ", date=" + date + "]";
	}
	
	

}
