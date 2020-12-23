package com.hibernateexample.entity;

import static com.hibernateexample.util.Constraints.MOBILE_NO_SIZE;
import static com.hibernateexample.util.Constraints.MOBILE_NO_VALID;
import static com.hibernateexample.util.Constraints.MOBILE_PATTERN;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "employee")
public class Employee extends BaseClass {

	// please enable the following comments to work with custom sequence
//	@Id
////	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee-seq")
////	@SequenceGenerator(initialValue = 1, name = "employee-seq", sequenceName = "employee-sequence", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
	@NotNull(message = "first Name must be required but found null")
	@NotBlank(message = "first Name must be required but found Blank")
	@NotEmpty(message = "first Name must be required but found Empty")
	private String firstName;
	@NotNull(message = "last Name must be required but found null")
	@NotBlank(message = "last Name must be required but found Blank")
	@NotEmpty(message = "last Name must be required but found Empty")
	private String lastName;
	@Email(message = "please enter valid email address")
	private String email;
	@Pattern(regexp = MOBILE_PATTERN, message = MOBILE_NO_VALID)
	@Size(min = 10, max = 10, message = MOBILE_NO_SIZE)
	private String mobileNumber;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "employeeAddress")
	private List<Address> address;
	@OneToOne(fetch = FetchType.LAZY)
	private BankAccount bankAccount;

	private Instant createdAt;
	private Instant updatedAt;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public Employee(Integer id,
			@NotNull(message = "first Name must be required but found null") @NotBlank(message = "first Name must be required but found Blank") @NotEmpty(message = "first Name must be required but found Empty") String firstName,
			@NotNull(message = "last Name must be required but found null") @NotBlank(message = "last Name must be required but found Blank") @NotEmpty(message = "last Name must be required but found Empty") String lastName,
			@Email(message = "please enter valid email address") String email,
			@Pattern(regexp = "(^$|[0-9]{10})") String mobileNumber, Instant createdAt, Instant updatedAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Employee() {
	}

}
