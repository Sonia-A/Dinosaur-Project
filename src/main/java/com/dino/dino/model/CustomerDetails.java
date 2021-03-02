package com.dino.dino.model;

import org.springframework.stereotype.Component;

@Component
public class CustomerDetails {
 private String fullName;
 private String fullAddress;
 private String phoneNumber;
private String address;
	private String modeOfPayment;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	@Override
	public String toString() {
		return "CustomerDetails{" +
				"fullName='" + fullName + '\'' +
				", fullAddress='" + fullAddress + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", address='" + address + '\'' +
				", modeOfPayment='" + modeOfPayment + '\'' +
				'}';
	}
}
