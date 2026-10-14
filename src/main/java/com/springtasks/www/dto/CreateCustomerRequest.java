package com.springtasks.www.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateCustomerRequest {
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	 @NotBlank(message = "Full name is required")
	 @Size(max = 100, message = "Full name cannot exceed 100 characters")
	private String fullName;
     @NotBlank(message = "Phone number is required")
	private String phone;
     @NotBlank(message = "Address is required")
     @Size(max = 255, message = "Address cannot exceed 255 characters")
	private String address;
     @NotBlank(message = "City is required")
     @Size(max = 100, message = "City cannot exceed 100 characters")
	private String city;
     @NotBlank(message = "Pincode is required")
     @Pattern(
         regexp = "^[0-9]{6}$",
         message = "Pincode must contain 6 digits"
     )
	private String pincode;
	

}
