package pl.first.project.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.first.project.springproject.services.OrderService;
import pl.first.project.springproject.services.PerformanceService;
import pl.first.project.springproject.services.UserService;

import static pl.first.project.springproject.utils.SecurityUser.getPrincipal;

@Controller
public class MyAccountController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/myaccount", method = RequestMethod.GET)
    public String account(Model model){
        model.addAttribute("user",userService.findUser(getPrincipal()));
        return "myaccountpage";
    }

    @RequestMapping(value = "/myaccount/order", method = RequestMethod.GET)
    public String accountOrder(Model model){
        model.addAttribute("user",userService.findUser(getPrincipal()));
        model.addAttribute("allorder",orderService.getAllOrder(userService.findUser(getPrincipal()).getId()));
        return "informationaboutorder";
    }

    @RequestMapping(value = "/myaccount/info", method = RequestMethod.GET)
    public String accountInfo(Model model){
        model.addAttribute("user",userService.findUser(getPrincipal()));
        return "informationaboutuser";
    }
}
