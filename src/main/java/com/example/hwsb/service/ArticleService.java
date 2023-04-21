package com.example.hwsb.service;


import com.example.hwsb.model.Article;
import com.example.hwsb.model.Category;
import com.example.hwsb.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    // Find all articles
    // POJO
    List<Article> findAll();

    Article findByUuid(String uuid);

    void delete(String uuid);

    boolean update(Article article, MultipartFile file);


    boolean save(Article article, MultipartFile file);
    Article findArticleByCategory(Category category);
    List<User> user();
    List<Category> category();
}
