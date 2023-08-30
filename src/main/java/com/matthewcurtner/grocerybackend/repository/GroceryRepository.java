package com.matthewcurtner.grocerybackend.repository;

import com.matthewcurtner.grocerybackend.model.Grocery;
import org.springframework.data.repository.CrudRepository;

public interface GroceryRepository extends CrudRepository<Grocery, Integer> {
}
