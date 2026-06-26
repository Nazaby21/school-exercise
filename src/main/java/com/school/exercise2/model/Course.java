package com.school.exercise2.model;

import com.school.exercise2.dto.CourseResponse;
import com.school.exercise2.dto.StudentResponse;
import com.school.exercise2.gender.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String studentName;
    private String description;

    public Course(String name, String studentName, String description) {
        this.name = name;
        this.studentName = studentName;
        this.description = description;
    }

    public CourseResponse toResponse() {
        return new CourseResponse(id, name, studentName, description);
    }
}
