package com.springjpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;
import com.springjpa.repo.CustomerSpecifications;
import com.springjpa.utils.CreateEntityUtils;

@RestController
public class WebController {

	@Autowired
	CustomerRepository repository;

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String process() {
		repository.save(CreateEntityUtils.createCustomer("Jack", "Smith", true));
		repository.save(CreateEntityUtils.createCustomer("Adam", "Johnson", false));
		repository.save(CreateEntityUtils.createCustomer("Kim", "Smith", true));
		repository.save(CreateEntityUtils.createCustomer("David", "Williams", false));
		repository.save(CreateEntityUtils.createCustomer("Peter", "Davis", true));
		return "Done";
	}

	@RequestMapping(value = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAll() {

		List<Customer> custList = new ArrayList<Customer>();
		for (Customer cust : repository.findAll()) {
			custList.add(cust);
		}
		return custList;
	}

	@RequestMapping(value = "/findbyid", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer findById(@RequestParam("id") long id) {
		Customer result = repository.findOne(id);
		return result;
	}

	@RequestMapping(value = "/findbyFirstname", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer fetchDataByLastName(@RequestParam("firstName") String firstName) {
		Customer cust = new Customer();
		cust.setFirstName(firstName);
		Specification<Customer> userNameIs = CustomerSpecifications.<Customer>userNameIs(cust);
		System.out.println("**********************" + userNameIs);
		return repository.findOne(userNameIs);

//		List<Customer> custList = new ArrayList<Customer>();
//		for (Customer cust : repository.findByFirstName(lastName)) {
//			custList.add(cust);
//		}
//		return custList;
	}

	@RequestMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
	public String fetchDataByLastName(@RequestParam("id") long id) {
		repository.delete(id);
		return "Success";
	}

}
