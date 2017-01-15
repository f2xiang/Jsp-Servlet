package com.fx.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Check implements Serializable{
	private Integer c_id;
	private String worktime;
	private String hometime;
	private String hometype;
	private String worktype;
	private Integer u_id;
	
	
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	

	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public String getHometime() {
		return hometime;
	}
	public void setHometime(String hometime) {
		this.hometime = hometime;
	}
	public String getHometype() {
		return hometype;
	}
	public void setHometype(String hometype) {
		this.hometype = hometype;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setu_id(Integer u_id) {
		this.u_id = u_id;
	}
	
	
}
