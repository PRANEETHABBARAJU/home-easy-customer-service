package com.springtasks.www.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtasks.www.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	Optional<Customer> findByAuthUserId(Integer authUserId);

    boolean existsByAuthUserId(Integer authUserId);

    boolean existsByPhone(String phone);

    boolean existsByPhoneAndAuthUserIdNot(
            String phone,
            Integer authUserId
    );
}
