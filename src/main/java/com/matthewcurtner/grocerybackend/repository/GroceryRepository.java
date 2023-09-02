package com.matthewcurtner.grocerybackend.repository;

import com.matthewcurtner.grocerybackend.model.Grocery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<Grocery, Integer> {
    Page<Grocery> findAll(Pageable pageable);
    Page<Grocery> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
