package ru.job4j.accident.control;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;

@Controller
@AllArgsConstructor
public class AccidentControl {
    private final AccidentService accidents;

    @GetMapping("/createAccident")
    public String viewCreateAccident() {
        return "createAccident";
    }

    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident) {
        accidents.create(accident);
        return "redirect:/index";
    }

    @PostMapping("/updateAccident")
    public String edit(@ModelAttribute Accident accident) {
        accidents.edit(accident);
        return "redirect:/index";
    }

    @GetMapping("/formAccident/{accidentId}")
    private String accidentAccident(Model model, @PathVariable("accidentId") int id) {
        model.addAttribute("accident", accidents.findById(id));
        return "editAccident";
    }
}