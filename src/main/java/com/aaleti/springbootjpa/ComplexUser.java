package com.aaleti.springbootjpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COMPLE_USER")
public class ComplexUser {

	@EmbeddedId
	private UserKey userKey;

	private String firstName;

	public UserKey getUserKey() {
		return userKey;
	}

	public void setUserKey(UserKey userKey) {
		this.userKey = userKey;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
