package com.example.endsem.service;

import com.example.endsem.entity.Investor;
import com.example.endsem.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class InvestorService {
    
    @Autowired
    private InvestorRepository repo;

    // Method to save a single Investor
    public Investor saveInvestor(Investor investor) {
        return repo.save(investor);
    }

    // Method to retrieve all Investors
    public List<Investor> getAllInvestors() {
        return repo.findAll();
    }

    // Method to retrieve Investors by name
    public List<Investor> getInvestorByName(String name) {
        return repo.findByName(name);
    }

    // Method to retrieve Investor by ID
    public Optional<Investor> getInvestorById(Long id) {
        return repo.findById(id);
    }

    // New method to generate and save bulk Investors
    public void generateAndSaveInvestors() {
        Random random = new Random();
        List<Investor> investors = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Investor investor = new Investor();
            investor.setName("Investor" + i);
            investor.setEmail("investor" + i + "@example.com");
            investor.setStockName("Stock" + random.nextInt(50));
            investor.setInvestmentAmount(5000 + (random.nextDouble() * 100000));
            investor.setInvestmentDate(new Date());

            investor.setCreatedBy("system");
            investor.setUpdatedBy("system");
            investor.setDeletedBy(null);
            Date now = new Date();
            investor.setDateCreated(now);
            investor.setDateUpdated(now);
            investor.setDateDeleted(null);
            investor.setVersion("v1");

            // Custom update: change `updatedBy` and `deletedBy` for a subset of records
            if (i % 5 == 0) { // For every 5th record, set `updatedBy` and `deletedBy`
                investor.setUpdatedBy("admin");
                investor.setDeletedBy("admin");
                investor.setDateUpdated(now);
                investor.setDateDeleted(now);
            }

            investors.add(investor);
        }

        repo.saveAll(investors);
    }
}
