package ru.job4j.accident.control;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.AccidentTypeService;
import ru.job4j.accident.service.RuleService;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class AccidentControl {

    private final AccidentService accidents;
    private final AccidentTypeService accidentTypeService;
    private final RuleService ruleService;

    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accident.setRules(ruleService.findByIds(ids));
        accident.setType(accidentTypeService.findById(accident.getType().getId()).get());
        accidents.create(accident);
        return "redirect:/";
    }

    @PostMapping("/updateAccident")
    public String edit(@ModelAttribute Accident accident) {
        String name = accident.getName();
        accident = accidents.findById(accident.getId()).get();
        accident.setName(name);
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
        model.addAttribute("rules", ruleService.findAll());
        model.addAttribute("types", accidentTypeService.findAll());
        return "createAccident";
    }
}