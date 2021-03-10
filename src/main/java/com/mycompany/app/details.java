package com.mycompany.app;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@javax.persistence.Table(name="details")
public class details {
@Id
@Column(name="ID")
private int id;
public details(){}
public details(int id, String name, int age) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Column (name="NAME")
private String name;
@Column (name="AGE")
private int age; 
}
