package org.lessons.java.spring_la_mia_pizzeria_webapi.repo;

import org.lessons.java.spring_la_mia_pizzeria_webapi.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    
    public List<Pizza> findByNameContainingIgnoreCase(String name);

}
