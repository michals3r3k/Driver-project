package pl.michals3r3k.driverproject.service;

import pl.michals3r3k.driverproject.dto.AdviceResponse;
import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.entity.Answer;
import pl.michals3r3k.driverproject.entity.Question;

import java.util.List;

public interface AdviceService {
    List<Advice> findAll();
    void add(Advice advice);
    Advice findById(Long id);
    void addQuestionToAdvice(Advice advice, Question question);
    Question findQuestionByIdAndAdvice(Long adviceId, Long questionId);
    void addAnswerToQuestion(Question question, Answer answer);
    Advice findNewest();
    AdviceResponse adviceToResponse(Advice newest);
    List<AdviceResponse> mostPopular(int i);
}
