package com.briup.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.briup.web.converter.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Integer age;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	public User() {}
	
	public User(String name, Integer age, Date dob) {
		this(null,name,age,dob);
	}
	public User(String name, Integer age) {
		this(null,name,age,new Date());
	}
	public User(Long id, String name, Integer age) {
		this(id,name,age,new Date());
	}
	public User(Long id, String name, Integer age, Date dob) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + "]";
	}
}
