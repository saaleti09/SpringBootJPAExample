package com.aaleti.springbootjpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries(@NamedQuery(name = "GetUserByUserIdNamedQuery", query = " from User where userId =: userId"))
public class User {

	/*
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	 * 
	 * @SequenceGenerator(name = "generator", sequenceName = "saaleti_custom",
	 * allocationSize = 1)
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	private String userName;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private UserProfile userProfile;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		System.out.println("Setting User Id" + userId);
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}
