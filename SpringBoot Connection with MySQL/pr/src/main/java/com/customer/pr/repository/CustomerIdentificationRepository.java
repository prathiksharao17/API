package com.customer.pr.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.pr.entity.CustomerIdentification;

public interface CustomerIdentificationRepository extends JpaRepository<CustomerIdentification, Long> {
	
}
