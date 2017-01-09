package com.fx.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Check implements Serializable{
	private Integer c_id;
	private String worktime;
	private String hometime;
	private String hometype;
	private String worktype;
	private Integer p_id;
	
	
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
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	
	
}
