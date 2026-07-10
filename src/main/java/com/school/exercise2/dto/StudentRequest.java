package com.school.exercise2.dto;

import com.school.exercise2.gender.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    @NotBlank(message = "Username is required")
    private String name;
    @NotBlank(message = "Email is required")
    private String email;
    private Gender gender;
    private CardRequest card;
}
