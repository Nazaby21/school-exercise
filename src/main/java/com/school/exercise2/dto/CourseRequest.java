package com.school.exercise2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {
    @NotBlank(message = "Course name is required")
    private String name;
    @NotNull(message = "Student id is required")
    private Long studentId;
    private String description;
}
