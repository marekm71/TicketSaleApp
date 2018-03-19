package pl.first.project.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.first.project.springproject.model.User;
import pl.first.project.springproject.services.PerformanceService;
import pl.first.project.springproject.services.UserService;

import static pl.first.project.springproject.utils.SecurityUser.getPrincipal;

@Controller
public class BasketController {

    @Autowired
    UserService userService;

    @Autowired
    PerformanceService performanceService;

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String allItems(Model model){
        model.addAttribute("allinbasket",userService.getAllFromBasket(userService.findUser(getPrincipal()).getId()));
        return "basket";
    }

    @RequestMapping(value = "/basket/addtobasket/{id}")
    public String addToBuy(@PathVariable("id") Integer integer){
        User user = userService.findUser(getPrincipal());
        userService.addToBasket(integer,user.getId());
        return "redirect:/basket";
    }

    @RequestMapping(value = "/basket/removeticket/{id}")
    public String removeFromBasket(@PathVariable("id") Integer integer){
        userService.removeFromBasket(integer);
        return "redirect:/basket";
    }

}
