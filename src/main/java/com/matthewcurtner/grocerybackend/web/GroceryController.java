package com.matthewcurtner.grocerybackend.web;

import com.matthewcurtner.grocerybackend.model.Grocery;
import com.matthewcurtner.grocerybackend.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/groceries")
    public Iterable<Grocery> getAllGroceries() {
        return groceryService.getAll();
    }

    @GetMapping("/grocery/{id}")
    public Grocery getGrocery(@PathVariable int id) {
        Grocery grocery = groceryService.getById(id);
        if (grocery == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return grocery;
    }
}
