package com.example.hwsb.repository;

import com.example.hwsb.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    @Select("SELECT * FROM categories")
    List<Category> findAllCategories();
    @Select("SELECT * FROM categories WHERE cateId = #{cateId}")
    Category findById(String cateId);

}
