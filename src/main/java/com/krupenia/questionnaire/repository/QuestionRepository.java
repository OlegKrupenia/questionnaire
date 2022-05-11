package com.krupenia.questionnaire.repository;

import com.krupenia.questionnaire.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
