package com.krupenia.questionnaire.contollers;

import com.krupenia.questionnaire.domain.Question;
import com.krupenia.questionnaire.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping
    public String showQuestionList(Model model) {
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        var questions = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + id));

        model.addAttribute("question", questions);
        return "update-question";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Question question,
                              Model model) {
//        questionRepository.save(question);
        System.out.println(question);
        var nextId = id++;
        return "redirect:/edit/" + nextId;
    }

}
