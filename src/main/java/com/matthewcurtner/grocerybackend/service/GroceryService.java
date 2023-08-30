package com.matthewcurtner.grocerybackend.service;

import com.matthewcurtner.grocerybackend.model.Grocery;
import com.matthewcurtner.grocerybackend.model.GroceryPage;
import com.matthewcurtner.grocerybackend.model.GrocerySearchCriteria;
import com.matthewcurtner.grocerybackend.repository.GroceryCriteriaRepository;
import com.matthewcurtner.grocerybackend.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;
    @Autowired
    private GroceryCriteriaRepository groceryCriteriaRepository;

    public Page<Grocery> getGroceries(GroceryPage groceryPage, GrocerySearchCriteria grocerySearchCriteria) {
        return groceryCriteriaRepository.findAllWithFilters(groceryPage, grocerySearchCriteria);
    }
}
