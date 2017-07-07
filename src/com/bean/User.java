package com.bean;

import java.util.Date;


public class User  {


	private Integer userId;
	
	private Date registeredDate;

	
	/**
	 * This defines the name of the user
	 */
	private String username;

	/**
	 * This defines the email of the user
	 */
	private String email;

	/**
	 * This defines the password of the user
	 */
	private String password;

	/**
	 * This defines the country of the user
	 */
	private String country;

	/**
	 * This defines the phone number of the user
	 */
	private String phone;


	
	private String sex;
	
	private String userrole;


	public Integer getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

	/**
	 * 
	 * @return registeredDate
	 */
	public Date getRegisteredDate() {
		return registeredDate;
	}

	/**
	 * 
	 * @param registeredDate
	 */
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	

	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}


	@Override
	public String toString() {
	
		return ""+this.getCountry()+"\n"+this.getEmail()+"\n"+this.getPassword()+"\n"+this.getPhone()+"\n"+this.getSex()+"\n" +
				""+this.getUsername()+"\n"+this.getUserrole()+"\n"+this.getUserId()+"\n"+this.getRegisteredDate()+"\n";
	}	
}