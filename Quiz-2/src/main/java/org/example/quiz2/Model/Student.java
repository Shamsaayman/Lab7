package org.example.quiz2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "id cannot be empty")
    @Size(min=3, message="id should be more then 2 characters")
    private String id;
    @NotEmpty(message = "name cannot be empty")
    @Size(min=5, message="name should be more then 4 characters")
    @Pattern(regexp = "^[a-zA-Z]+$" , message = "name should only contain characters")
    private String name;
    @NotNull(message = "age cannot be empty")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = " age must be a number")
    private int age ;
    @NotNull(message = "email cannot be empty")
    @Email(message = "must be a valid email")
    private String email ;
    @NotEmpty(message = "major cannot be empty")
    private String major;
}
