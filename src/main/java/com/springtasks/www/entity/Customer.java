package com.springtasks.www.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Integer customerId;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getAuthUserId() {
		return authUserId;
	}
	public void setAuthUserId(Integer authUserId) {
		this.authUserId = authUserId;
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
	public Customer(Integer customerId, Integer authUserId, String fullName, String phone, String address, String city,
			String pincode, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.customerId = customerId;
		this.authUserId = authUserId;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Customer() {
		super();
	}
	@Column(name="auth_user_id",nullable=false,unique=true)
	private Integer authUserId;
	@Column(name="full_name",nullable=false,length=100)
	private String fullName;
	@Column(name="phone",nullable=false,unique=true,length=20)
	private String phone;
	@Column(name="address",nullable=false,length=255)
	private String address;
	@Column(name="city",nullable=false,length=100)
	private String city;
	@Column(name="pincode",nullable=false,length=10)
	private String pincode;
	@Column(name = "created_at",
	        insertable = false,
	        updatable = false)
	private LocalDateTime createdAt;
	@Column(name = "updated_at",
        insertable = false,
        updatable = false)
	private LocalDateTime updatedAt;
}
