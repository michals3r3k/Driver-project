package pl.michals3r3k.driverproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michals3r3k.driverproject.entity.TrainingQuestion;
import pl.michals3r3k.driverproject.repository.TrainingQuestionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingQuestionServiceImpl implements TrainingQuestionService {
    private final TrainingQuestionRepository trainingQuestionRepository;

    @Override
    public List<TrainingQuestion> findAll() {
        return trainingQuestionRepository.findAll();
    }
}
