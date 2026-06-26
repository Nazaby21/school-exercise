package com.school.exercise2.dto;

import com.school.exercise2.gender.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    private String name;
    private String email;
    private Gender gender;
}
