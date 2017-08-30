package com.po;

import java.sql.*;
import java.util.*;

public class User {

	private String password;
	private Integer id;
	private String username;


	public String getPassword() {
		return this.password;
	}
	public Integer getId() {
		return this.id;
	}
	public String getUsername() {
		return this.username;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
