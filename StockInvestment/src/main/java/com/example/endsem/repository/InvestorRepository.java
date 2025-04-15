package com.example.endsem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.endsem.entity.Investor;

public interface InvestorRepository extends JpaRepository<Investor,Long> {
	List<Investor> findByName(String name);

	

}
