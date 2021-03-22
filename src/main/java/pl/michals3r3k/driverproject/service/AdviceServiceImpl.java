package pl.michals3r3k.driverproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.entity.Answer;
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
    private final AnswerService answerService;

    @Override
    public List<Advice> findAll() {
        return adviceRepository.findAll();
    }

    @Override
    public Question findQuestionByIdAndAdvice(Long adviceId, Long questionId) {
        Advice advice = findById(adviceId);
        for(Question q: advice.getQuestions()){
            if(q.getId().equals(questionId)){
                return q;
            }
        }

        throw new IllegalStateException("Question not found");
    }

    @Override
    public void add(Advice advice) {
        advice.setDateOfPublic(LocalDate.now());
        advice.setTimeOfPublic(LocalTime.now());
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
        add(advice);
    }

    @Override
    @Transactional
    public void addAnswerToQuestion(Question question, Answer answer) {
        List<Answer> questionAnswers = question.getQuestionAnswers();
        questionAnswers.add(answer);
        question.setQuestionAnswers(questionAnswers);
        answerService.save(answer);
        questionService.save(question);
    }
}
