package org.lessons.java.spring_la_mia_pizzeria_webapi.repo;

import org.lessons.java.spring_la_mia_pizzeria_webapi.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Integer>{

}
