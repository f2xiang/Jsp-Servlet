package com.fx.beans;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
	private Integer p_id;
	private String name;
	private Integer age;
	private Double sal;
	private Date birth;
	private String phone;
	private String address;
	private Integer u_id;
	private Integer d_id;
	
	
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
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
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	@Override
	public String toString() {
		return "Person [p_id=" + p_id + ", name=" + name + ", age=" + age
				+ ", sal=" + sal + ", birth=" + birth + ", phone=" + phone
				+ ", address=" + address + ", u_id=" + u_id + ", d_id=" + d_id
				+ "]";
	}
	
	
}
