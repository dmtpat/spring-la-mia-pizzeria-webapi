package org.lessons.java.spring_la_mia_pizzeria_webapi.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "You must insert a title")
    private String title;

    @NotNull(message = "You must insert an initial date")
    @FutureOrPresent(message = "The date must be today or in the future")
    private LocalDate startingDate;

    @NotNull(message = "You must insert an final date")
    @Future(message = "The date must be in the future")
    private LocalDate finalDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    @JsonBackReference
    private Pizza pizza;

    //-------------------------------getter-&-setter-------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
