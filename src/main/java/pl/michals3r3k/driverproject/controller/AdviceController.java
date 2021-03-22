package pl.michals3r3k.driverproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.entity.Question;
import pl.michals3r3k.driverproject.service.AdviceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/advice")
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

    @PutMapping("/{id}")
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


}
