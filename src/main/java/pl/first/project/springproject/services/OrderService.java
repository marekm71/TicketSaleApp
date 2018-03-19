package pl.first.project.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.first.project.springproject.model.Order;
import pl.first.project.springproject.repository.implement.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrder(int numberUser){
        return orderRepository.getAllOrder(numberUser);
    }

    public Order getOrder(int numberOrder){
        return orderRepository.getOrder(numberOrder);
    }

}
