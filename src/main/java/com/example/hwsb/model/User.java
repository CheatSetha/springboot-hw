package com.example.hwsb.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String fullName;

    private String username;
    private String email;
    private String address;
    private String bio;
    private String gender;
    private String profilePicture;
    private String coverPicture;

}
