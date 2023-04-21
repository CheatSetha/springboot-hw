package com.example.hwsb.service;

import com.example.hwsb.model.Category;
import com.example.hwsb.model.User;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findById(String cateId);
}
