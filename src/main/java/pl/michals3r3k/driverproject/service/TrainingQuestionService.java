package pl.michals3r3k.driverproject.service;

import pl.michals3r3k.driverproject.entity.TrainingQuestion;

import java.util.List;

public interface TrainingQuestionService {
    List<TrainingQuestion> findAll();

    void save(TrainingQuestion question);
}
