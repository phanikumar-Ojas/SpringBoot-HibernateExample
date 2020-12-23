package com.hibernateexample.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.hibernateexample.util.Constraints.*;

@Entity(name = "bankaccount")
public class BankAccount extends BaseClass {

	@NotNull(message = ACCOUNT_NO_NULL)
	@NotBlank(message = ACCOUNT_NO_BLANK)
	@NotEmpty(message = ACCOUNT_NO_EMPTY)
	@Pattern(regexp = MOBILE_PATTERN, message = ACCOUNT_NO_VALID)
	private String bankAccountNo;

	private String branchName;

	private String IFSCCODE;

	@NotNull(message = MOBILE_NO_NULL)
	@NotBlank(message = MOBILE_NO_BLANK)
	@NotEmpty(message = MOBILE_NO_EMPTY)
	@Pattern(regexp = MOBILE_PATTERN, message = MOBILE_NO_VALID)
	@Size(min = 10,max = 10,message = MOBILE_NO_SIZE)
	private String mobile;

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIFSCCODE() {
		return IFSCCODE;
	}

	public void setIFSCCODE(String iFSCCODE) {
		IFSCCODE = iFSCCODE;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "BankAccount [bankAccountNo=" + bankAccountNo + ", branchName=" + branchName + ", IFSCCODE=" + IFSCCODE
				+ ", mobile=" + mobile + "]";
	}

	public BankAccount(
			@NotNull(message = " ACCOUNT NUMBER REQUIRED BUT FOUND NULL") @NotBlank(message = " ACCOUNT NUMBER REQUIRED BUT FOUND BLANK") @NotEmpty(message = " ACCOUNT NUMBER REQUIRED BUT FOUND EMPTY") @Pattern(regexp = "(^$|[0-9]{10})", message = "PLEASE ENTER A VALIED ACCOUNT NUMBER") String bankAccountNo,
			String branchName, String iFSCCODE,
			@NotNull(message = "MOBILE NUMBER REQUIRED BUT FOUND NULL") @NotBlank(message = "MOBILE NUMBER REQUIRED BUT FOUND BLANK") @NotEmpty(message = "MOBILE NUMBER REQUIRED BUT FOUND EMPTY") @Pattern(regexp = "(^$|[0-9]{10})", message = "PLEASE ENTER A VALID MOBILE NUMBER") String mobile) {
		super();
		this.bankAccountNo = bankAccountNo;
		this.branchName = branchName;
		IFSCCODE = iFSCCODE;
		this.mobile = mobile;
	}

	public BankAccount() {
	}

}
