package com.customer.pr.controller;

import com.customer.pr.entity.CustomerIdentification;
import com.customer.pr.service.CustomerIdentificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer-identification")
public class CustomerIdentificationController {
	
	 @Autowired
	 private CustomerIdentificationService customerIdentificationService;
	 
	 @GetMapping
	 public List<CustomerIdentification> getAllCustomerIdentifications() {
		 return customerIdentificationService.getAllCustomerIdentifications();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<?> getCustomerIdentificationById(@PathVariable("id") Long id) {
	     Optional<CustomerIdentification> customerIdentification = customerIdentificationService.getCustomerIdentificationById(id);
	     
	     if (customerIdentification.isPresent()) {
	         return new ResponseEntity<>(customerIdentification.get(), HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>("Customer Identification not found with ID: " + id, HttpStatus.NOT_FOUND);
	     }
	 }

	 
	 @PostMapping
	 public ResponseEntity<CustomerIdentification> createCustomerIdentification(@RequestBody CustomerIdentification newCustomerIdentification) {
		 CustomerIdentification savedCustomerIdentification = customerIdentificationService.createCustomerIdentification(newCustomerIdentification);
	 	return new ResponseEntity<>(savedCustomerIdentification, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<?> updateCustomerIdentification(@PathVariable("id") Long id, 
	                                                       @RequestBody CustomerIdentification newCustomerIdentification) {
	     try {
	         CustomerIdentification updatedCustomerIdentification = 
	             customerIdentificationService.updateCustomerIdentification(id, newCustomerIdentification);
	         return new ResponseEntity<>(updatedCustomerIdentification, HttpStatus.OK);
	     } catch (RuntimeException e) {
	         return new ResponseEntity<>("Customer Identification not found with ID: " + id, HttpStatus.NOT_FOUND);
	     }
	 }

	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> deleteCustomerIdentification(@PathVariable("id") Long id) {
	     try {
	         customerIdentificationService.deleteCustomerIdentification(id);
	         return new ResponseEntity<>("Customer Identification deleted successfully.", HttpStatus.NO_CONTENT);
	     } catch (RuntimeException e) {
	         return new ResponseEntity<>("Customer Identification not found with ID: " + id, HttpStatus.NOT_FOUND);
	     }
	 }

}