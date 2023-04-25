package se.hkr.java.db.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.hkr.java.db.entities.Furniture;

import java.util.ArrayList;

@Controller
public class FurnitureController {

    @GetMapping("/furnitures")
    public String showFurnitureList(Model model) {
        model.addAttribute("furnitures", new ArrayList<Furniture>());
        return "furniture-list";
    }

    @GetMapping("/furnitures/new")
    public String showNewFurnitureForm(Model model) {
        return "furniture-new";
    }

    @PostMapping("/furnitures")
    public String createFurniture(@ModelAttribute("furniture") Furniture furniture) {
        return "redirect:/furnitures";
    }
}
