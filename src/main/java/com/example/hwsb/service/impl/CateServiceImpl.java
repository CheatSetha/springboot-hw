package com.example.hwsb.service.impl;

import com.example.hwsb.model.Category;
import com.example.hwsb.repository.CategoryMapper;
import com.example.hwsb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CateServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllCategories() {
        return categoryMapper.findAllCategories();
    }

    @Override
    public Category findById(String cateId) {
        return categoryMapper.findById(cateId);
    }
}
