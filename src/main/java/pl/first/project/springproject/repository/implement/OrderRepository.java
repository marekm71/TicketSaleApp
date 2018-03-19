package pl.first.project.springproject.repository.implement;

import org.springframework.stereotype.Repository;
import pl.first.project.springproject.model.Order;
import pl.first.project.springproject.model.User;
import pl.first.project.springproject.repository.OrderRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepository implements OrderRepositoryInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> getAllOrder(int numberUser) {
        User user = entityManager.find(User.class,numberUser);
        return user.getOrderList();
    }

    @Override
    public Order getOrder(int numberOrder){
        return entityManager.find(Order.class,numberOrder);
    }
}
