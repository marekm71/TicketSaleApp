package pl.first.project.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.first.project.springproject.model.User;
import pl.first.project.springproject.services.OrderService;
import pl.first.project.springproject.services.PerformanceService;
import pl.first.project.springproject.services.UserService;

import static pl.first.project.springproject.utils.SecurityUser.getPrincipal;

@Controller
public class OrderController {
    @Autowired
    UserService userService;

    @Autowired
    PerformanceService performanceService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/submitorder")
    public String submitOrder(){
        User user = userService.findUser(getPrincipal());
        userService.addNewOrder(user);
        return "redirect:/myaccount/order";
    }

    @RequestMapping(value = "/order/details/{id}")
    public String orderDetails(@PathVariable("id") Integer integer, Model model){
        model.addAttribute("orders",orderService.getOrder(integer));
        return "orderdetails";
    }

    @RequestMapping(value = "/backtoorder")
    public String backToOrder(){
        return "redirect:/myaccount/order";
    }

}
