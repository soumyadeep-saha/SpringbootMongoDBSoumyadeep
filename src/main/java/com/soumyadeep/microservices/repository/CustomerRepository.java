package com.soumyadeep.microservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.soumyadeep.microservices.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

	public Customer findByLocation(String location);
}
