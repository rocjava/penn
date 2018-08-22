package com.lawyer.core.entity;

import java.io.Serializable;
import java.util.Date;

public class Lawyer implements Serializable{
	
	private static final long serialVersionUID = 6605645624341620452L;
	
	private int id;
	private String name;
	private int age;
	private String mobile;
	private String email;
	private String telephone;
	private String level;
	private int workingYears;
	private String degree;
	private String gender;
	private String university;
	private String status;
	private Date createDate;
	private Date lastModifyDate;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getWorkingYears() {
		return workingYears;
	}
	public void setWorkingYears(int workingYears) {
		this.workingYears = workingYears;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	@Override
	public String toString() {
		return "Lawyer [id=" + id + ", name=" + name + ", age=" + age
				+ ", mobile=" + mobile + ", email=" + email + ", telephone="
				+ telephone + ", level=" + level + ", workingYears="
				+ workingYears + ", degree=" + degree + ", gender=" + gender
				+ ", university=" + university + ", status=" + status
				+ ", createDate=" + createDate + ", lastModifyDate="
				+ lastModifyDate + "]";
	}

	
}
