package ru.job4j.accident.control;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.AccidentTypeService;

@Controller
@AllArgsConstructor
public class AccidentControl {
    private final AccidentService accidents;
    private final AccidentTypeService accidentTypeService;

    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident) {
        System.out.println(accident);
        accidents.create(accident);
        return "redirect:/";
    }

    @PostMapping("/updateAccident")
    public String edit(@ModelAttribute Accident accident) {
        accidents.edit(accident);
        return "redirect:/";
    }

    @GetMapping("/formAccident/{accidentId}")
    private String accidentAccident(Model model, @PathVariable("accidentId") int id) {
        model.addAttribute("accident", accidents.findById(id));
        return "editAccident";
    }

    @GetMapping("/formUpdateAccident")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.findById(id));
        return "editAccident";
    }

    @GetMapping("/createAccident")
    public String viewCreateAccident(Model model) {
        model.addAttribute("types", accidentTypeService.findAll());
        return "createAccident";
    }
}