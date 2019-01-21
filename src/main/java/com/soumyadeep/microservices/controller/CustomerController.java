package com.soumyadeep.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soumyadeep.microservices.model.Customer;
import com.soumyadeep.microservices.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	//get all customers
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<Customer> getCustomers(){
		
		return customerRepository.findAll();
	}
	
	//create or save customers
	@RequestMapping(value="/customers", method=RequestMethod.POST)
	public String saveCustomers(@RequestBody Customer customer){
		
		customerRepository.save(customer);
		return "{\"output\" : \"Data saved successfully\"}";
	}
	
	//update customers
	@RequestMapping(value="/customers", method=RequestMethod.PUT)
	public String updateCustomer(@RequestBody Customer customer) {
		
		customerRepository.save(customer);
		return "{\"output\" : \"Data updated successfully\"}";
	}
	
	//delete all customers
	@RequestMapping(value="/customers", method=RequestMethod.DELETE)
	public String deleteCustomers(){
		
		customerRepository.deleteAll();
		return "{\"output\" : \"Data deleted successfully\"}";
	}
	
	//delete by parameter
	@RequestMapping(value="/customers/{location}", method=RequestMethod.DELETE)
	public String deleteCustomerByParameter(@PathVariable("location") String location){
		
		customerRepository.delete(location);
		return "{\"output\" : \"Data deleted successfully\"}";
	}
	
/*	//get by param
	@RequestMapping(value="/customers/{location}", method=RequestMethod.GET)
	public Customer getByLocation(@PathVariable("location") String location){
		
		return customerRepository.findByLocation(location);
	}*/
	
	//get by single param only for primary key
	@RequestMapping(value="/customers/{param}", method=RequestMethod.GET)
	public Customer getByOneParam(@PathVariable("param") String param){
		
		return customerRepository.findOne(param);
	}
}
