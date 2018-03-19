package pl.first.project.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.first.project.springproject.model.User;
import pl.first.project.springproject.services.PerformanceService;
import pl.first.project.springproject.services.UserService;

import javax.validation.Valid;

import static pl.first.project.springproject.utils.SecurityUser.getPrincipal;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registerpanel", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user",new User());
        return "registerform";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registerform";
        }
        else {
            userService.createUser(user);
            return "redirect:/loginpanel";
        }
    }
}
