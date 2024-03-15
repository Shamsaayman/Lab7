package org.example.quiz2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    @NotNull(message = "id cannot be empty")
    @Size(min=3, message="id should be more then 2 characters")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    @Size(min=5, message="name should be more then 4 characters")
    private String name;
    @NotEmpty(message = "type cannot be empty")
    @Pattern(regexp = "^(Virtual|In Person|Hybrid)$", message = "please enter valid course typd")
    private String type;
    @NotNull(message = "id cannot be empty")
    @Positive(message = "must be positive")
    @Size(min=1, max=100)
    private int capacity;
}
