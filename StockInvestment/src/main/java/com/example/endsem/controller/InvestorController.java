package com.example.endsem.controller;

import com.example.endsem.entity.Investor;
import com.example.endsem.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    @Autowired
    private InvestorService service;

    // Endpoint to create a single Investor
    @PostMapping
    public Investor createInvestor(@RequestBody Investor investor) {
        return service.saveInvestor(investor);
    }

    // Endpoint to retrieve all Investors
    @GetMapping
    public List<Investor> getAllInvestors() {
        return service.getAllInvestors();
    }

    // Endpoint to retrieve Investors by name
    @GetMapping("/name/{name}")
    public List<Investor> getInvestorByName(@PathVariable String name) {
        return service.getInvestorByName(name);
    }

    // Endpoint to retrieve Investor by ID
    @GetMapping("/{id}")
    public Optional<Investor> getInvestorById(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    // Endpoint to generate bulk data (1000 Investors)
    @PostMapping("/generate")
    public String generateInvestors() {
        service.generateAndSaveInvestors();
        return "50 Investors generated and saved successfully!";
    }
}
