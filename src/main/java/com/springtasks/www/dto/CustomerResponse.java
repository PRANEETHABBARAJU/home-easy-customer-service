package com.springtasks.www.dto;

import java.time.LocalDateTime;

public class CustomerResponse {
	private Integer customerId;
    public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public CustomerResponse() {
		super();
	}
	public CustomerResponse(Integer customerId, String fullName, String phone, String address, String city,
			String pincode, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	private String fullName;
    private String phone;
    private String address;
    private String city;
    private String pincode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
