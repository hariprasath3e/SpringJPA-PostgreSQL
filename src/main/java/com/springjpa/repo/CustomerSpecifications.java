package com.springjpa.repo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.springjpa.model.Customer;
import com.springjpa.model.Customer_;

public class CustomerSpecifications {

	public static <T extends Customer> Specification<T> userNameIs(final Customer user) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				System.out.println("************ CN " + Customer_.firstName);
				System.out.println("************ CB " + user.getFirstName());
				return cb.equal(root.<String>get(Customer_.firstName), user.getFirstName());
			}
		};
	}
}