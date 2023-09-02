package com.matthewcurtner.grocerybackend.service;

import com.matthewcurtner.grocerybackend.model.Grocery;
import com.matthewcurtner.grocerybackend.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    public Page<Grocery> getAllGroceries(int pageNumber, String searchKey) {
        Pageable pageable = PageRequest.of(pageNumber, 50);

        if (searchKey.isEmpty()) {
            return groceryRepository.findAll(pageable);
        } else {
            return groceryRepository.findByNameContainingIgnoreCase(searchKey, pageable);
        }
    }
}
