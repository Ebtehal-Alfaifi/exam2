package com.example.exam.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Valid
public class BookModel {
    @NotEmpty(message = " id can not be null")
    @Size(min = 3,max = 3,message = " id should has only 3 characters")
    private String id;

    @NotEmpty(message = " book name can not be null")
    @Size(min = 2,message = " book name at least should has 2 characters")
    private String name;

@NotNull(message = "number of pages can not be null")
    @Min(value = 3,message = " number if pages at least 3 ")
    private int NumberOfpages;

    @NotNull(message = " price can not be null")
    @Min(value = 5,message = " price at least 5$")
    private int price;

    @NotEmpty(message = " category can not be null")
    @Pattern(regexp = "^(?i)(novel|academic)$",message = "category is novel OR academic")
    private String category;

    @NotNull(message = " is available can not be null")
    @AssertTrue(message = " is available must be True")
    private boolean isAvailable;

}
