package com.school.exercise2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {
    @NotBlank(message = "Course name is required")
    private String name;
    @NotBlank(message = "Student name is required")
    private String studentName;
    private String description;
}
