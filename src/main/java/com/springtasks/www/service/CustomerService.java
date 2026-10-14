package com.springtasks.www.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springtasks.www.dto.CreateCustomerRequest;
import com.springtasks.www.dto.CustomerResponse;
import com.springtasks.www.dto.UpdateCustomerRequest;
import com.springtasks.www.entity.Customer;
import com.springtasks.www.exceptionHandling.CustomerAlreadyExistsException;
import com.springtasks.www.exceptionHandling.CustomerNotFoundException;
import com.springtasks.www.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse createCustomer(
            Integer authUserId,
            CreateCustomerRequest request) {

        if (customerRepository.existsByAuthUserId(
                authUserId)) {

            throw new CustomerAlreadyExistsException(
                "A customer profile already exists for this user"
            );
        }

        if (customerRepository.existsByPhone(
                request.getPhone())) {

            throw new CustomerAlreadyExistsException(
                "This phone number is already registered"
            );
        }

        Customer customer = new Customer();

        customer.setAuthUserId(authUserId);
        customer.setFullName(request.getFullName());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setPincode(request.getPincode());

        Customer savedCustomer =
            customerRepository.save(customer);

        return convertToResponse(savedCustomer);
    }
    public List <CustomerResponse> getallCustomers() {
    	List<Customer> customers = customerRepository.findAll();
    	List<CustomerResponse> response = new ArrayList<>();
    	for(Customer customer:customers) {
    		response.add(convertToResponse(customer));
    	}
    	return response;
    	
    }

    public CustomerResponse getCustomerByAuthUserId(
            Integer authUserId) {

        Customer customer = customerRepository
            .findByAuthUserId(authUserId)
            .orElseThrow(() ->
                new CustomerNotFoundException(
                    "Customer not found for auth user ID: "
                        + authUserId
                )
            );

        return convertToResponse(customer);
    }

    public CustomerResponse updateCustomer(
            Integer authUserId,
            UpdateCustomerRequest request) {

        Customer customer = customerRepository
            .findByAuthUserId(authUserId)
            .orElseThrow(() ->
                new CustomerNotFoundException(
                    "Customer not found for auth user ID: "
                        + authUserId
                )
            );

        if (customerRepository
                .existsByPhoneAndAuthUserIdNot(
                    request.getPhone(),
                    authUserId)) {

            throw new CustomerAlreadyExistsException(
                "This phone number is already registered"
            );
        }

        customer.setFullName(request.getFullName());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setPincode(request.getPincode());

        Customer updatedCustomer =
            customerRepository.save(customer);

        return convertToResponse(updatedCustomer);
    }

    private CustomerResponse convertToResponse(
            Customer customer) {

        return new CustomerResponse(
            customer.getCustomerId(),
            customer.getFullName(),
            customer.getPhone(),
            customer.getAddress(),
            customer.getCity(),
            customer.getPincode(),
            customer.getCreatedAt(),
            customer.getUpdatedAt()
        );
    }
}