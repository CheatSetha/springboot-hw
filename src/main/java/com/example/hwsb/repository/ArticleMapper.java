package com.example.hwsb.repository;


import com.example.hwsb.model.Article;
import com.example.hwsb.model.Category;
import com.example.hwsb.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    @Select("SELECT * FROM articles")
    @Result(column = "uuid", property = "uuid")
    List<Article> findAll();
    @Select("SELECT * FROM users ")
    List<User> user();
    @Select("SELECT * FROM categories")
    List<Category> category();
    @Insert("INSERT INTO articles (uuid, title,author, thumbnail ,cate_id) VALUES (#{a.uuid}, #{a.title},#{a.author}, #{a.thumbnail},#{a.cateId})")
    void insert(@Param("a") Article article ,MultipartFile file,  List<Category> category);
    @Select("SELECT * FROM articles WHERE uuid = #{uuid}")
    Article findByUuid(String uuid);
    @Delete("DELETE FROM articles WHERE uuid = #{uuid}")
    void delete( String uuid);
    @Update("UPDATE articles SET title = #{a.title}, author = #{a.author}, thumbnail = #{a.thumbnail} WHERE uuid = #{a.uuid}")
    void update(@Param("a") Article article);
    @Select("SELECT * FROM articles WHERE cateId = #{cate.cateId}")
    Article findArticleByCategory(@Param("cate") Article article);
}
