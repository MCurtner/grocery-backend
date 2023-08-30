package com.matthewcurtner.grocerybackend.web;

import com.matthewcurtner.grocerybackend.model.Grocery;
import com.matthewcurtner.grocerybackend.model.GroceryPage;
import com.matthewcurtner.grocerybackend.model.GrocerySearchCriteria;
import com.matthewcurtner.grocerybackend.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/groceries")
    public ResponseEntity<Page<Grocery>> getGroceries(GroceryPage groceryPage,
                                                      GrocerySearchCriteria grocerySearchCriteria) {
        return new ResponseEntity<>(groceryService.getGroceries(groceryPage, grocerySearchCriteria), HttpStatus.OK);
    }

    @GetMapping("/groceries/filter")
    public ResponseEntity<Page<Grocery>> getGroceriesByPageAndSize(@RequestParam int page,
                                                      @RequestParam int size,
                                                      GrocerySearchCriteria grocerySearchCriteria) {
        GroceryPage groceryPage = new GroceryPage(page, size);
        return new ResponseEntity<>(groceryService.getGroceries(groceryPage, grocerySearchCriteria), HttpStatus.OK);
    }
}
