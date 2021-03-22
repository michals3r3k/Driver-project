package pl.michals3r3k.driverproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.entity.TrainingQuestion;
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

    @PostMapping("/add")
    public void addAdvicePost(@RequestBody Advice advice){
        adviceService.save(advice);
    }

    @PutMapping("/{id}")
    public void addQuestionToAdvice(@PathVariable Long id, @RequestBody TrainingQuestion question){
        Advice advice = adviceService.findById(id);
        adviceService.addQuestionToAdvice(advice, question);
    }


}
