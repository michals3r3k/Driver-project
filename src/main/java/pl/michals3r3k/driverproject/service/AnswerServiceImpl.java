package pl.michals3r3k.driverproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michals3r3k.driverproject.entity.Answer;
import pl.michals3r3k.driverproject.repository.AnswerRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService{
    private final AnswerRepository answerRepository;

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }
}
