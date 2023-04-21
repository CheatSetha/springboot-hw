package com.example.hwsb.controller;


import com.example.hwsb.model.Article;
import com.example.hwsb.model.Category;
import com.example.hwsb.service.ArticleService;
import com.example.hwsb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    @GetMapping("/")
    String viewHome(Model model) {
        List<Article> articles = articleService.findAll();
        List<Category> categories = categoryService.findAllCategories();

        model.addAttribute("articles", articles);
        model.addAttribute("categories", categories);
        return "pages/index";
    }

}
