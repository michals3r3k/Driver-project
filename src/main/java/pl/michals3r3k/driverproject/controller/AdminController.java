package pl.michals3r3k.driverproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.michals3r3k.driverproject.entity.Advice;
import pl.michals3r3k.driverproject.service.AdviceService;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdviceService adviceService;

    @GetMapping("/advice/all")
    public String adviceAllGet(Model model){
        model.addAttribute("advices", adviceService.findAll());
        return "advice/all";
    }

    @GetMapping("/advice/add")
    public String adviceAddGet(Model model){
        model.addAttribute("advice", new Advice());
        return "advice/add";
    }

    @PostMapping("/advice/add")
    public String adviceAddPost(Advice advice){
        adviceService.add(advice);
        return "redirect:/admin/advice/all";
    }

}
