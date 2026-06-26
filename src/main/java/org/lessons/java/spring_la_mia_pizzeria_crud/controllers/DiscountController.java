package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Discount;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.repo.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    private DiscountRepository repository;

    // @GetMapping("/create")
    // public String create(Model model) {

    //     model.addAttribute("discount", new Discount());

    //     return "discounts/create-edit";
    // }

    @PostMapping("/create")
    private String store(
        @Valid @ModelAttribute("discount") Discount formDiscount,
                BindingResult bindingResult,
                        Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "discounts/create-edit";
        }
        repository.save(formDiscount);
        return "redirect:/pizza/" + formDiscount.getPizza().getId();
    }
    
    @GetMapping("/edit/{id}")
    private String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("discount", repository.findById(id).get());
        model.addAttribute("edit", true);
        return "discounts/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(
        @Valid @ModelAttribute("discount") Discount formDiscount, 
                BindingResult bindingResult,
                        Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "discounts/create-edit";
        }

        repository.save(formDiscount);
        return "redirect:/pizza/" + formDiscount.getPizza().getId();
    }
    
    @PostMapping("/delete/{id}")
    private String delete(@PathVariable Integer id, Model model) {
        Integer pizzaId = repository.findById(id).get().getPizza().getId();
        repository.deleteById(id);
        return "redirect:/pizza/" + pizzaId;
    }
}
