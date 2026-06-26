package org.lessons.java.spring_la_mia_pizzeria_crud.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Discount;
import org.lessons.java.spring_la_mia_pizzeria_crud.repo.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    public Discount getById(Integer id) {
        Optional<Discount> discountAttempt = discountRepository.findById(id);
        if (discountAttempt.isEmpty()) {
            // not found
        }
        return discountAttempt.get();
    }

    public Discount create(Discount discount) {
        return discountRepository.save(discount);
    }

    public Discount update(Discount discount) {
        return discountRepository.save(discount);
    }

    public void delete(Discount discount) {
        discountRepository.delete(discount);
    }

    public void deleteById(Integer id) {
        Discount discount = getById(id);
        delete(discount);
    }
    
}
