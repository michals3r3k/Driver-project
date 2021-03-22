package pl.michals3r3k.driverproject.service;

import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.entity.Question;

import java.util.List;

public interface AdviceService {
    List<Advice> findAll();
    void add(Advice advice);
    Advice findById(Long id);
    void addQuestionToAdvice(Advice advice, Question question);
    Question findQuestionByIdAndAdvice(Long adviceId, Long questionId);
}
