package pl.first.project.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.first.project.springproject.model.Performance;
import pl.first.project.springproject.services.PerformanceService;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class PerformanceController {

    @Autowired
    PerformanceService performanceService;

    @RequestMapping(value = "/addperformancepanel", method = RequestMethod.GET)
    public String newPerformance(Model model){
        model.addAttribute("performance",new Performance());
        return "newperformance";
    }

    @RequestMapping(value = "/newperformance", method = RequestMethod.POST)
    public String newPerformance(@Valid Performance performance, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           return "newperformance";
        }
        else {
            performance.setDate(LocalDateTime.parse(performance.getDateString()));
            performanceService.createPerformance(performance);
            return "redirect:/repertoire";
       }
    }
}
