package se.hkr.java.db.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.hkr.java.db.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/new")
    public String showOrderForm(Model model, @RequestParam("employeeId") Long employeeId) {
        model.addAttribute("employeeId", employeeId);
        // Find all furnitures and customers
        model.addAttribute("furnitures", new ArrayList<Furniture>());
        model.addAttribute("customers", new ArrayList<Customer>());
        return "order-new";
    }

    @PostMapping()
    public String createOrder(@RequestParam Long employeeId,
                              @RequestParam LocalDate orderDate,
                              @RequestParam Long customerId,
                              @RequestParam(name = "furniture") List<Long> furnitureIds,
                              @RequestParam(name = "quantity") List<Integer> quantities) {

        // find employee by id
        Employee employee = new Employee();

        // find customer by id
        Customer customer = new Customer();

        // create order head
        OrderHead orderHead = new OrderHead();

        // create order lines
        List<OrderLine> orderLines = new ArrayList<>();
        for (int i = 0; i < furnitureIds.size(); i++) {
            Long furnitureId = furnitureIds.get(i);
            if (furnitureId == null) continue;
            Furniture furniture = new Furniture();
            OrderLine orderLine = new OrderLine();
            orderLines.add(orderLine);
        }

        // save order

        return "redirect:/employees";
    }
}
