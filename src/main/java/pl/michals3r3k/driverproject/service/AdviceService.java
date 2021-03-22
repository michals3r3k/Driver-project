package pl.michals3r3k.driverproject.service;

import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.entity.TrainingQuestion;

import java.util.List;

public interface AdviceService {
    List<Advice> findAll();
    void save(Advice advice);
    Advice findById(Long id);
    void addQuestionToAdvice(Advice advice, TrainingQuestion question);
}
