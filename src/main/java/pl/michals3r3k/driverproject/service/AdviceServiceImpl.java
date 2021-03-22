package pl.michals3r3k.driverproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.entity.Question;
import pl.michals3r3k.driverproject.repository.AdviceRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AdviceServiceImpl implements AdviceService {
    private final AdviceRepository adviceRepository;
    private final QuestionService questionService;

    @Override
    public List<Advice> findAll() {
        return adviceRepository.findAll();
    }

    @Override
    public void save(Advice advice) {
        adviceRepository.save(advice);
    }

    @Override
    public Advice findById(Long id) {
        return adviceRepository.findById(id).orElseThrow(()-> new IllegalStateException("Advice does not exists"));
    }

    @Override
    @Transactional
    public void addQuestionToAdvice(Advice advice, Question question) {
        List<Question> questions = advice.getQuestions();
        question.setDateOfPublic(LocalDate.now());
        question.setTimeOfPublic(LocalTime.now());
        questions.add(question);
        questionService.save(question);
        save(advice);
    }
}
