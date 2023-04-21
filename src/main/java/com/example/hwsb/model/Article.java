package com.example.hwsb.model;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private String uuid;

    @NotBlank(message = "Title is required..!")
    private String title;
   //@NotBlank(message = "thumbnail is required..!")
    private String thumbnail;
    @NotBlank(message = "description is required..!")
    private String description;
    private List<User> author;
    private List<Category> category;


}
