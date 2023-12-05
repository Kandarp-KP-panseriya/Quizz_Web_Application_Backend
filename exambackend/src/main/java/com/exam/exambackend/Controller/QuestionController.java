package com.exam.exambackend.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exambackend.Model.Question;
import com.exam.exambackend.Model.Quizz;
import com.exam.exambackend.Services.QuestionServices;
import com.exam.exambackend.Services.QuizzServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionServices questionServices;

    @Autowired
    private QuizzServices quizzServices;

    @PostMapping("/")
    public ResponseEntity<Question> addqes(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionServices.addQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionServices.updaQuestion(question));
    }

    // get all qes of any quzz
    @GetMapping("/quizz/{quzzid}")
    public ResponseEntity<?> getQuestionofQuizz(@PathVariable("quzzid") Long id) {
        Quizz quizz = this.quizzServices.getsinglequizz(id);
        Set<Question> questions = quizz.getQuestion();
        List<?> list = new ArrayList<>(questions);
        if (list.size() > Integer.parseInt(quizz.getNumberofQuestions())) {
            list = list.subList(0, Integer.parseInt(quizz.getNumberofQuestions() + 1));

        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);

    }

    @GetMapping("/quizz/all/{quzzid}")
    public ResponseEntity<?> getQuestionofQuizzadmin(@PathVariable("quzzid") Long id) {
        Quizz quizz = new Quizz();
        quizz.setQid(id);
        List<Question> questions = this.questionServices.getquestionsofquizz(quizz);
        List<?> list = new ArrayList<>(questions);
        return ResponseEntity.ok(list);

    }

    // get single qes
    @GetMapping("/{sqid}")
    public Question getsingq(@PathVariable("sqid") Long sqid) {
        return this.questionServices.getsinglequestion(sqid);
    }

    @DeleteMapping("/{dqid}")
    public void delete(@PathVariable("dqid") Long id) {
        this.questionServices.deletequestion(id);
    }
}
