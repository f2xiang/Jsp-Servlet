package com.fx.beans;

import java.io.Serializable;

public class User implements Serializable{
	private Integer u_id;
	
	private String uname;
	
	private String pwd;
	
	private Integer level;
	
	
	//----------------------
	
	private String newPassword;
	private String confrimPassword;
	
	

	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfrimPassword() {
		return confrimPassword;
	}

	public void setConfrimPassword(String confrimPassword) {
		this.confrimPassword = confrimPassword;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", uname=" + uname + ", pwd=" + pwd
				+ ", level=" + level + ", newPassword=" + newPassword
				+ ", confrimPassword=" + confrimPassword + "]";
	}

	
	
	
}
