package com.springjpa.utils;

import java.util.Arrays;

import com.springjpa.model.Address;
import com.springjpa.model.Customer;

public class CreateEntityUtils {

	public static Customer createCustomer(String fn, String ln, boolean withAddress) {
		Customer cust = new Customer();
		cust.setFirstName(fn);
		cust.setLastName(ln);
		if (withAddress) {
			cust.setAddress(Arrays.asList(createAddress()));
		}
		return cust;
	}

	public static Address createAddress() {
		Address address = new Address();
		address.setLineOne("1173 QUEEN LANE");
		address.setLineTwo("APT 4");
		address.setCity("WEST CHESTER");
		address.setCountry("US");
		address.setState("PA");
		address.setZip("19382");
		return address;
	}

}
