package com.example.exam.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Valid
public class UserModel {
    @NotEmpty(message = " id can not be null")
    @Size(min = 3,max = 3,message = " length of id should be 3 character only")
    private String id;
    @NotEmpty(message = " name can not be null")
    @Size(min = 2,message = " name at least should has 2 characters")
    private String name;
    @NotNull(message = " age can not be null")
    @Min(value = 15,message = " your age should be 15 at least")
    private int age;
    @NotNull(message = " you should enter balance")
    @Positive(message = " you should enter valid number")
    @Min(value = 1,message = " your balence at least should has 1$")
    private int balance;

    @NotEmpty(message = " you should enter role")
    @Pattern(regexp = "^(?i)(customer|libraian)$",message = " should be customer or libraian  ")
    private String role;
}
