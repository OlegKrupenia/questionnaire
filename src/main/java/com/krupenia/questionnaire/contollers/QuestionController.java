package com.krupenia.questionnaire.contollers;

import com.krupenia.questionnaire.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping
    public String showQuestionList(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "index";
    }
}
