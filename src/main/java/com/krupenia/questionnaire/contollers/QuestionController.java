package com.krupenia.questionnaire.contollers;

import com.krupenia.questionnaire.domain.Question;
import com.krupenia.questionnaire.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    private int successCounter; // state will be stored in the DB later.

    @GetMapping
    public String showQuestionList(Model model) {
        successCounter = 0;
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        long count = questionRepository.count();
        if (id > count ) {
            var rate = successCounter == 0 ? 0.0d : successCounter * 100.0d / count;
            model.addAttribute("rate", rate);
            return "results";
        }
        var questions = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + id));

        model.addAttribute("question", questions);
        return "update-question";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Question question,
                             Model model) {
        if (question.getCorrectAnswer().equals(question.getSelectedAnswer())) {
            log.info("{} is correct", id);
            successCounter++;
        } else {
            log.info("{} is wrong. Correct answer is {}\n", id, question.getCorrectAnswer());
        }
        var nextId = ++id;
        return "redirect:/edit/" + nextId;
    }

}
