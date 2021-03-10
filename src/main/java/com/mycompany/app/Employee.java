package com.mycompany.app;
import javax.persistence.*;
import org.hibernate.*;
@Entity
@Table(name="EMPLOYEE")
public class Employee
{
	@Id @GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="First_name")
	private String firstName;
        
	@Column(name="salary")
	private int salary; 

	@Lob
	//@Type(type="org.hibernate.type.BinaryType")
	@Column(name="picture")
	private byte[] picture; 

	public Employee() {}
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id=id; 
	}
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public int getSalary(){
		return salary;
	}
	public void setSalary(int salary){
		this.salary=salary;
	}
	
}
