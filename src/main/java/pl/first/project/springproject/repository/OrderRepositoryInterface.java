package pl.first.project.springproject.repository;

import pl.first.project.springproject.model.Order;

import java.util.List;

public interface OrderRepositoryInterface {
    List<Order> getAllOrder(int numberUser);

    Order getOrder(int numberOrder);
}
