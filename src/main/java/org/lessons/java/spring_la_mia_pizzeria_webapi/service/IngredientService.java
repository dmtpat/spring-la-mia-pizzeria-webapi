package org.lessons.java.spring_la_mia_pizzeria_webapi.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_la_mia_pizzeria_webapi.model.Ingredient;
import org.lessons.java.spring_la_mia_pizzeria_webapi.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Ingredient getById(Integer id) {
        Optional<Ingredient> ingredientAttempt = ingredientRepository.findById(id);

        if (ingredientAttempt.isEmpty()) {
            //NOT_FOUND
        }
        return ingredientAttempt.get();
    }

    public Ingredient create(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient update(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public void delete(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }

    public void delteById(Integer id) {
        delete(getById(id));
    }

    public Boolean existsById(Integer id) {
        return ingredientRepository.existsById(id);
    }

    public Boolean exists(Ingredient ingredient) {
        return existsById(ingredient.getId());
    }
}
