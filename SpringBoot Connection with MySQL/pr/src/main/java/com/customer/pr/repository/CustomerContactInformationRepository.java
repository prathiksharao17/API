package com.customer.pr.repository;

import com.customer.pr.entity.CustomerContactInformation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContactInformationRepository extends JpaRepository<CustomerContactInformation, Long> {
	
}