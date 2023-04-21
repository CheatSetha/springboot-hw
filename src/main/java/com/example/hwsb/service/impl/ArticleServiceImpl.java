package com.example.hwsb.service.impl;
import com.example.hwsb.model.Article;
import com.example.hwsb.model.Category;
import com.example.hwsb.model.FileUpload;
import com.example.hwsb.model.User;
import com.example.hwsb.repository.ArticleMapper;
import com.example.hwsb.service.ArticleService;
import com.example.hwsb.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final FileUploadService fileUploadService;
    private final ArticleMapper articleMapper;
    @Override
    public List<Article> findAll() {
        // TODO:
        // Your logic
        List<Article> articles = articleMapper.findAll();
        return articles;
    }
    @Override
    public Article findByUuid(String uuid) {
        return articleMapper.findByUuid(uuid);
    }


    public void delete(String uuid) {
        articleMapper.delete(uuid);
    }

//    @Override
//    public boolean update(Article article, MultipartFile file) {
//        return false;
//    }

    @Override
    public boolean update(Article article, MultipartFile file) {


        System.out.println("article "+ article);

        FileUpload fileUpload = fileUploadService.uploadSingle(file);
        if (fileUpload.isSucceed()) {
            article.setThumbnail(fileUpload.fileName());

            articleMapper.update(article);
        }
        return true;
    }
    @Override
    public boolean save(Article article, MultipartFile file, List<Category> category) {
        FileUpload fileUpload = fileUploadService.uploadSingle(file);
        if (fileUpload.isSucceed()) {
            article.setUuid(UUID.randomUUID().toString());
            article.setThumbnail(fileUpload.fileName());
            articleMapper.insert(article, file ,category);

        }
        return true;
    }

    @Override
    public Article findArticleByCategory(Category category) {
        return null;
    }

    @Override
    public List<User> user() {
        return articleMapper.user();
    }

    @Override
    public List<Category> category() {
        return articleMapper.category();
    }
}
