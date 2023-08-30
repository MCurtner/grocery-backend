package com.matthewcurtner.grocerybackend.service;

import com.matthewcurtner.grocerybackend.model.Grocery;
import com.matthewcurtner.grocerybackend.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    public Iterable<Grocery> getAll() {
        return groceryRepository.findAll();
    }

    public Grocery getById(int id) {
        return groceryRepository.findById(id).orElse(null);
    }
}
