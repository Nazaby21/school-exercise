package com.school.exercise2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CardResponse {

    private Long id;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String cardNumber;
}
