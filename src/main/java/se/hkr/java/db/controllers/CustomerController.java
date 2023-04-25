package se.hkr.java.db.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.hkr.java.db.entities.Customer;

import java.util.ArrayList;

@Controller
public class CustomerController {

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", new ArrayList<Customer>());
        return "customer-list";
    }

    @GetMapping("/customers/new")
    public String showNewCustomerForm(Model model) {
        return "customer-new";
    }

    @PostMapping("/customers")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        return "redirect:/customers";
    }
}
