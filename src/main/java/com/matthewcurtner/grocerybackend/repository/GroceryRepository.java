package com.matthewcurtner.grocerybackend.repository;

import com.matthewcurtner.grocerybackend.model.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<Grocery, Integer> {
}
