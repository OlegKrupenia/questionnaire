package com.krupenia.questionnaire.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "questions")
public class Question {
    @Id
    private Integer questionId;
    @Column(name = "question")
    private String question;
    @Column(name = "option_a")
    private String optionA;
    @Column(name = "option_b")
    private String optionB;
    @Column(name = "option_c")
    private String optionC;
    @Column(name = "option_d")
    private String optionD;
    @Column(name = "option_e")
    private String optionE;
    @Column(name = "correct_answer")
    private String correctAnswer;
    @Transient
    private String selectedAnswer;


    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                '}';
    }
}
