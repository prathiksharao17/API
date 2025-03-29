package com.customer.pr.repository;

import com.customer.pr.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
}

