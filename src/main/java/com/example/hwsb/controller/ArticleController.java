package com.example.hwsb.controller;


import com.example.hwsb.model.Article;
import com.example.hwsb.model.Category;
import com.example.hwsb.repository.ArticleMapper;
import com.example.hwsb.service.ArticleService;
import com.example.hwsb.service.CategoryService;
import com.example.hwsb.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;
    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping

    String viewArticle(Model model){
        List<Article> articles = articleMapper.findAll();
        List<Category> categoriesList = categoryService.findAllCategories();
        model.addAttribute("articles", articles);
        model.addAttribute("categoriesList", categoriesList);
        return "pages/article/article";
    }

    @GetMapping("/new")
    String viewArticleNew(Article article, Model model ) {
        model.addAttribute("article", article);
        model.addAttribute("users", articleMapper.user());
        model.addAttribute("categories", articleMapper.category());
        List<Category> categories = categoryService.findAllCategories().stream().toList();
        System.out.println("obj = " + categories.stream().iterator().next().getCateId());

        return "pages/article/article-new";
    }

    @PostMapping("/new")
    String doSaveArticle(@ModelAttribute @Valid Article article,
                         @RequestParam("cateId") List<String> cate_id,
                         BindingResult result,
//       @RequestParam("userId") List<String> userId,
                         @RequestParam("thumbnailFile") MultipartFile file,
                         Model model) {
        //filter category
        List<Category> categories = categoryService.findAllCategories().stream().filter(c -> cate_id.contains(c.getCateId())).toList();


        if (result.hasErrors()) {
            model.addAttribute("article", article);

            return "pages/article/article-new";
        }

        boolean isSucceed =articleService.save(article, file, categories);
        if (isSucceed) {
            return "redirect:/article";
        }

        return "pages/article/article-new";
    }
    @GetMapping("/{uuid}")
    String articleDetail(@PathVariable("uuid") String uuid, Model model) {
        Article article = articleMapper.findByUuid(uuid);
        model.addAttribute("article", article);
        return "pages/article/article-detail";
    }

    @GetMapping("/delete/{uuid}")
    String deleteArticle(@PathVariable("uuid") String uuid) {
        articleService.delete(uuid);
        return "redirect:/article";
    }
//    update area

    @GetMapping("/edit/{uuid}")
    String editArticle(@PathVariable("uuid") String uuid, Model model) {
        Article article = articleMapper.findByUuid(uuid);
        System.out.println("uuid ="+article.getUuid());
        model.addAttribute("article", article);
        return "pages/article/article-edit";
    }
//    when click on btn update or save
    @PutMapping ("/update/{uuid}")
    String updateArticle(@PathVariable("uuid") String uuid,@ModelAttribute @Valid Article article
                         , BindingResult result
                         , @RequestParam("thumbnailFile") MultipartFile file,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("article", article);
            return "pages/article/article-edit";
        }

        boolean isSucceed = articleService.update(article, file);
        if (isSucceed) {
            return "redirect:/article";
        }
        return "pages/article/article-edit";
    }
//    end of update option
}
