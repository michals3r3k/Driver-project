package pl.michals3r3k.driverproject.service;

import pl.michals3r3k.driverproject.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    void save(Question question);
}
