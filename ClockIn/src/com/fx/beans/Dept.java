package com.fx.beans;

import java.io.Serializable;

public class Dept implements Serializable{
	private Integer d_id;
	
	private String dname;

	public Integer getD_id() {
		return d_id;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
	
}
