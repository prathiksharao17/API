package com.example.endsem.controller;

import com.example.endsem.service.InvestorService;
import com.example.endsem.entity.Investor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InvestorTableController {

    @Autowired
    private InvestorService service;

    // This method handles both search and non-search requests
    @GetMapping("/investor-table")
    public String showInvestorTable(@RequestParam(value = "name", required = false) String name, Model model) {
        List<Investor> investors;
        
        if (name != null && !name.isEmpty()) {
            // Filter investors by name if the name parameter is present
            investors = service.getInvestorByName(name);
        } else {
            // Show all investors if no name is provided
            investors = service.getAllInvestors();
        }
        
        model.addAttribute("investors", investors);
        model.addAttribute("searchName", name); // Add the current search name to the model for the form
        return "investor_table"; // Looks for templates/investor_table.html
    }
}
