package pl.first.project.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.first.project.springproject.model.Performance;
import pl.first.project.springproject.model.User;
import pl.first.project.springproject.services.OrderService;
import pl.first.project.springproject.services.PerformanceService;
import pl.first.project.springproject.services.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

import java.time.LocalDateTime;
import java.util.Date;

import static pl.first.project.springproject.utils.SecurityUser.getPrincipal;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    PerformanceService performanceService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        return "homepage";
    }

    @RequestMapping(value = "/repertoire", method = RequestMethod.GET)
    public String plan(Model model){
        model.addAttribute("allperformance",performanceService.getAllPerformance());
        return "repertoire";
    }



}
