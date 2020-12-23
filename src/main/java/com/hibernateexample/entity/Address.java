package com.hibernateexample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String landmark;
	private String line1;
	private String line2;
	private String city;
	@Email(message = "please enter a valid email ID")
	private String email;
	@Pattern(regexp = "(^$|[0-9]{10})", message = "please enter valid mobile number")
	private String mobile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address(Integer id, String landmark, String line1, String line2, String city, @Email String email,
			String mobile) {
		super();
		this.id = id;
		this.landmark = landmark;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.email = email;
		this.mobile = mobile;
	}

	public Address() {
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", landmark=" + landmark + ", line1=" + line1 + ", line2=" + line2 + ", city="
				+ city + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
