package org.lessons.java.spring_la_mia_pizzeria_webapi.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_la_mia_pizzeria_webapi.model.Discount;
import org.lessons.java.spring_la_mia_pizzeria_webapi.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_webapi.repo.DiscountRepository;
import org.lessons.java.spring_la_mia_pizzeria_webapi.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private DiscountRepository discountRepository;

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> findById(Integer id) {
        return pizzaRepository.findById(id);
    }

    public Pizza getById(Integer id) {
        Optional<Pizza> pizzaAttempt = pizzaRepository.findById(id);
        if (pizzaAttempt.isEmpty()) {
            // lanciare Not found
        }
        return pizzaAttempt.get();
    }

    public List<Pizza> findByName(String name) {
        return pizzaRepository.findByNameContainingIgnoreCase(name);
    }

    public Pizza create(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public void delete(Pizza pizza) {
        for (Discount discountToDelete : pizza.getDiscounts()) {
            discountRepository.delete(discountToDelete);
        }
        pizzaRepository.delete(pizza);
    }
    
    public void deleteById(Integer id) {
        Pizza pizza = getById(id);

        delete(pizza);
    }

    public Boolean existsById(Integer id) {
        return pizzaRepository.existsById(id);
    }

    public Boolean exists(Pizza pizza) {
        return existsById(pizza.getId());
    }
}
