package com.customer.pr.controller;

import com.customer.pr.entity.CustomerProofOfId;
import com.customer.pr.service.CustomerProofOfIdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer-proof-of-id")
public class CustomerProofOfIdController {
	
	 @Autowired
	 private CustomerProofOfIdService customerContactInformationService;
	 
	 @GetMapping
	 public List<CustomerProofOfId> getAllCustomerProofOfIds() {
		 return customerContactInformationService.getAllCustomerProofOfIds();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<CustomerProofOfId> getCustomerProofOfIdById(@PathVariable(name = "id") Long id) {
	     return customerContactInformationService.getCustomerProofOfIdById(id)
	             .map(item -> ResponseEntity.ok(item))
	             .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	 }

	 
	 @PostMapping
	 public ResponseEntity<CustomerProofOfId> createCustomerProofOfId(@RequestBody CustomerProofOfId newCustomerProofOfId) {
		 CustomerProofOfId savedCustomerIdentification = customerContactInformationService.createCustomerProofOfId(newCustomerProofOfId);
	 	return new ResponseEntity<>(savedCustomerIdentification, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<CustomerProofOfId> updateCustomerProofOfId(
	         @PathVariable(name = "id") Long id, 
	         @RequestBody CustomerProofOfId newCustomerProofOfId) {
	     try {
	         CustomerProofOfId updatedCustomerProofOfId = 
	                 customerContactInformationService.updateCustomerProofOfId(id, newCustomerProofOfId);
	         return ResponseEntity.ok(updatedCustomerProofOfId);
	     } catch (RuntimeException e) {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	     }
	 }

	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomerProofOfId(@PathVariable(name = "id") Long id) {
	     try {
	         customerContactInformationService.deleteCustomerProofOfId(id);
	         return ResponseEntity.noContent().build();
	     } catch (RuntimeException e) {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	     }
	 }

}