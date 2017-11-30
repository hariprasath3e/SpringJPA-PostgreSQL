package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springjpa.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>,
		JpaSpecificationExecutor<Customer>, JpaRepository<Customer, Long> {
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
}
