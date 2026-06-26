package com.school.exercise2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseResponse {
    private Long id;
    private String name;
    private String studentName;
    private String description;
}
