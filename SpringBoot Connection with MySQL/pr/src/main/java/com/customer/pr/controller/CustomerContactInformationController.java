package com.customer.pr.controller;

import com.customer.pr.entity.CustomerContactInformation;
import com.customer.pr.service.CustomerContactInformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer-contact-information")
public class CustomerContactInformationController {
	
	 @Autowired
	 private CustomerContactInformationService customerContactInformationService;
	 
	 @GetMapping
	 public List<CustomerContactInformation> getAllCustomerContactInformations() {
		 return customerContactInformationService.getAllCustomerContactInformations();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<CustomerContactInformation> getCustomerIdentificationById(
	         @PathVariable(name = "id") Long id) {
	     return customerContactInformationService.getCustomerContactInformationById(id)
	             .map(ResponseEntity::ok)
	             .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	 }

	 
	 @PostMapping
	 public ResponseEntity<CustomerContactInformation> createCustomerContactInformation(@RequestBody CustomerContactInformation newCustomerIdentification) {
		 CustomerContactInformation savedCustomerIdentification = customerContactInformationService.createCustomerContactInformation(newCustomerIdentification);
	 	return new ResponseEntity<>(savedCustomerIdentification, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<CustomerContactInformation> updateCustomerContactInformation(
	         @PathVariable(name = "id") Long id, 
	         @RequestBody CustomerContactInformation newCustomerContactInformation) {
	     try {
	         CustomerContactInformation updatedCustomerContactInformation = 
	                 customerContactInformationService.updateCustomerContactInformation(id, newCustomerContactInformation);
	         return ResponseEntity.ok(updatedCustomerContactInformation);
	     } catch (RuntimeException e) {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	     }
	 }

	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomerContactInformation(@PathVariable(name = "id") Long id) {
	     try {
	         customerContactInformationService.deleteCustomerContactInformation(id);
	         return ResponseEntity.noContent().build();
	     } catch (RuntimeException e) {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	     }
	 }

}