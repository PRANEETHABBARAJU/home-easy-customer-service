package com.springtasks.www.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtasks.www.dto.CreateCustomerRequest;
import com.springtasks.www.dto.CustomerResponse;
import com.springtasks.www.dto.UpdateCustomerRequest;
import com.springtasks.www.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(
	    originPatterns = {
	        "http://localhost:*",
	        "http://127.0.0.1:*"
	    }
	)
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService customerService;
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	@PostMapping("/profile")
	public ResponseEntity<CustomerResponse> createCustomer(
	        @AuthenticationPrincipal Integer authUserId,
	        @Valid @RequestBody CreateCustomerRequest request) {

	    CustomerResponse response =
	        customerService.createCustomer(
	            authUserId,
	            request
	        );

	    return ResponseEntity
	        .status(HttpStatus.CREATED)
	        .body(response);
	}
	@GetMapping("/me")
	public ResponseEntity<CustomerResponse>getCustomerByAuthUserId(@AuthenticationPrincipal Integer authUserId){
		CustomerResponse response = customerService.getCustomerByAuthUserId(authUserId);
		return ResponseEntity.ok(response);	
		}
    @PutMapping("/me")
	public ResponseEntity<CustomerResponse>updateCustomer(@AuthenticationPrincipal Integer authUserId,@Valid @RequestBody UpdateCustomerRequest request){
		CustomerResponse response = customerService.updateCustomer(authUserId, request);
				return ResponseEntity.ok(response);
	}
    @GetMapping("/details")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {

        List<CustomerResponse> response =
            customerService.getallCustomers();

        return ResponseEntity.ok(response);
    }

}
