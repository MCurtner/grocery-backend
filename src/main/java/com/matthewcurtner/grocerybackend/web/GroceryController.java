package com.matthewcurtner.grocerybackend.web;

import com.matthewcurtner.grocerybackend.model.Grocery;
import com.matthewcurtner.grocerybackend.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/groceries/all")
    public ResponseEntity<Page<Grocery>> getGroceries(@RequestParam int page) {
        return new ResponseEntity<>(groceryService.getAllGroceries(page, ""), HttpStatus.OK);
    }
    @GetMapping("/groceries")
    public ResponseEntity<Page<Grocery>> getGroceriesContainingName(@RequestParam int page, @RequestParam String name) {
        return new ResponseEntity<>(groceryService.getAllGroceries(page, name), HttpStatus.OK);
    }
}
