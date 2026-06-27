package org.lessons.java.spring_la_mia_pizzeria_webapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The ingredient name must contain a word")
    @Size(min = 3, message = "The ingredient name must contain at least 3 chars")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnoreProperties("category")
    private List<Pizza> pizzas;

    //---------------------------------------getter-&-setter--------------------->^.^<-------------------------------------
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    // Override del metodo equals per controllare se i valori sono presenti nella lista degli ingredienti 
    // dell0oggetto principale collegato (nelle checkbox)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ingredient)) {
            return false;
        }
        Ingredient ingredient = (Ingredient) o;
        return id != null && id.equals(ingredient.getId());
    }
}
