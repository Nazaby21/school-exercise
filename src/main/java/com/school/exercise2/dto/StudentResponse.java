package com.school.exercise2.dto;

import com.school.exercise2.gender.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private Gender gender;
    private CardResponse card;
}
