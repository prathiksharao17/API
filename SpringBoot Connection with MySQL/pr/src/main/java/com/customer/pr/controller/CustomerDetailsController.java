package com.customer.pr.controller;

import com.customer.pr.entity.CustomerDetails;
import com.customer.pr.service.CustomerDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer-details")
public class CustomerDetailsController {
	
	 @Autowired
	 private CustomerDetailsService customerDetailsService;
	 
	 @GetMapping
	 public List<CustomerDetails> getAllCustomersDetails() {
		 return customerDetailsService.getAllCustomersDetails();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<?> getCustomerDetailsById(@PathVariable("id") Long id) {
	     Optional<CustomerDetails> customerDetails = customerDetailsService.getCustomerDetailsById(id);
	     
	     if (customerDetails.isPresent()) {
	         return new ResponseEntity<>(customerDetails.get(), HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>("Customer not found with ID: " + id, HttpStatus.NOT_FOUND);
	     }
	 }

	 
	 @PostMapping
	 public ResponseEntity<CustomerDetails> createCustomerDetails(@RequestBody CustomerDetails newCustomerDetails) {
	 CustomerDetails savedCustomerDetails = customerDetailsService.createCustomerDetails(newCustomerDetails);
	 	return new ResponseEntity<>(savedCustomerDetails, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<?> updateCustomerDetails(@PathVariable("id") Long id, 
	                                                @RequestBody CustomerDetails newCustomerDetails) {
	     try {
	         CustomerDetails updatedCustomerDetails = 
	             customerDetailsService.updateCustomerDetails(id, newCustomerDetails);
	         return new ResponseEntity<>(updatedCustomerDetails, HttpStatus.OK);
	     } catch (RuntimeException e) {
	         return new ResponseEntity<>("Customer Details not found with ID: " + id, HttpStatus.NOT_FOUND);
	     }
	 }

	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> deleteCustomerDetails(@PathVariable("id") Long id) {
	     try {
	         customerDetailsService.deleteCustomerDetails(id);
	         return new ResponseEntity<>("Customer Details deleted successfully.", HttpStatus.NO_CONTENT);
	     } catch (RuntimeException e) {
	         return new ResponseEntity<>("Customer Details not found with ID: " + id, HttpStatus.NOT_FOUND);
	     }
	 }

}