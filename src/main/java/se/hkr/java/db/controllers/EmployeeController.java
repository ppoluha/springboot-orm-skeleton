package se.hkr.java.db.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.hkr.java.db.entities.Employee;
import se.hkr.java.db.entities.OrderHead;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @GetMapping("/employees")
    public String listStaff(Model model) {
        model.addAttribute("employees", new ArrayList<Employee>());
        return "employee-list";
    }

    @GetMapping("/employees/new")
    public String showNewEmployeeForm(Model model) {
        return "employee-new";
    }

    @PostMapping("/employees")
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}/orders")
    public String showEmployeeOrders(@PathVariable Long id, Model model) {
        Employee e = new Employee();
        model.addAttribute("orders", new OrderHead());
        model.addAttribute("employee", e);
        return "employee-orders";
    }
}
