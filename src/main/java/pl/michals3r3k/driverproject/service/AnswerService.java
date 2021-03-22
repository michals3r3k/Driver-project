package pl.michals3r3k.driverproject.service;

import pl.michals3r3k.driverproject.entity.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> findAll();
    void save(Answer answer);
}
