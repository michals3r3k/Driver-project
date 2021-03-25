package pl.michals3r3k.driverproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.michals3r3k.driverproject.dto.AdviceResponse;
import pl.michals3r3k.driverproject.dto.AnswerRequest;
import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.entity.Answer;
import pl.michals3r3k.driverproject.entity.Question;
import pl.michals3r3k.driverproject.service.AdviceService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/advice")
public class AdviceController {
    private final AdviceService adviceService;

    @GetMapping("/all")
    public List<Advice> allAdvicesGet(){
        return adviceService.findAll();
    }

    @GetMapping("/{id}")
    public Advice adviceGet(@PathVariable Long id){
        return adviceService.findById(id);
    }

    @PostMapping("/add")
    public void addAdvicePost(@RequestBody Advice advice){
        adviceService.add(advice);
    }

    @PostMapping("/{id}")
    public void addQuestionToAdvice(@PathVariable Long id, @RequestBody Question question){
        Advice advice = adviceService.findById(id);
        adviceService.addQuestionToAdvice(advice, question);
    }

    //Question Operations

    @GetMapping("/{adviceId}/questions")
    public List<Question> findAllByAdvice(@PathVariable Long adviceId){
        return adviceService.findById(adviceId).getQuestions();
    }

    @GetMapping("/{adviceId}/question/{questionId}")
    public Question findAllByAdvice(@PathVariable Long adviceId, @PathVariable Long questionId){
        return adviceService.findQuestionByIdAndAdvice(adviceId, questionId);
    }

    @PostMapping("/{adviceId}/question/{questionId}")
    public void addAnswerToQuestion(@PathVariable Long adviceId, @PathVariable Long questionId, @RequestBody Answer answer){
        Question question = adviceService.findQuestionByIdAndAdvice(adviceId, questionId);
        adviceService.addAnswerToQuestion(question, answer);
    }

    //Finding newest advice
    @GetMapping("/newest")
    public AdviceResponse newestAdviceGet(){
        return adviceService.adviceToResponse(adviceService.findNewest());
    }

    @PostMapping("/question/answer")
    public boolean answerForQuestion(@RequestBody AnswerRequest answerRequest){
        Question question = adviceService.findQuestionByIdAndAdvice(answerRequest.getAdviceId(), answerRequest.getQuestionId());
        Optional<Answer> first = question.getQuestionAnswers().stream().filter(Answer::isCorrect).findFirst();
        return first
                .filter(answer -> answer.getId().equals(answerRequest.getAnswerId()))
                .isPresent();
    }

    @GetMapping("/most-popular")
    public List<AdviceResponse> mostPopularGet(@RequestParam int max){
        return adviceService.mostPopular(max);
    }


}
