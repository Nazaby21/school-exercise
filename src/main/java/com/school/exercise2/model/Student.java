package com.school.exercise2.model;

import com.school.exercise2.dto.CardResponse;
import com.school.exercise2.dto.StudentResponse;
import com.school.exercise2.gender.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Gender gender;
    @OneToOne(mappedBy = "student")
    private Course course;
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;

    public Student(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public StudentResponse toResponse() {
        CardResponse cardResponse = null;
        if (card != null) {
            cardResponse = new CardResponse(
                    card.getId(),
                    card.getIssueDate(),
                    card.getExpiryDate(),
                    card.getCardNumber()
            );
        }
        return new StudentResponse(id, name, email, gender, cardResponse
        );
    }
}
