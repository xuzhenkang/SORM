package com.po;

import java.sql.*;
import java.util.*;

public class Emp {

	private String empname;
	private java.sql.Date birthday;
	private Double bonus;
	private Integer deptId;
	private Integer id;
	private Double salary;
	private Integer age;


	public String getEmpname() {
		return this.empname;
	}
	public java.sql.Date getBirthday() {
		return this.birthday;
	}
	public Double getBonus() {
		return this.bonus;
	}
	public Integer getDeptId() {
		return this.deptId;
	}
	public Integer getId() {
		return this.id;
	}
	public Double getSalary() {
		return this.salary;
	}
	public Integer getAge() {
		return this.age;
	}


	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


}
