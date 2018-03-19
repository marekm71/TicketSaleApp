package pl.first.project.springproject.repository;

import pl.first.project.springproject.model.Order;
import pl.first.project.springproject.model.Role;
import pl.first.project.springproject.model.Ticket;
import pl.first.project.springproject.model.User;

import java.util.List;
import java.util.Set;

public interface UserRepositoryInterface {
    
    void createUser(String username, String password, String firstname, String lastname);

    User findUser(String username);

    void createUser(User user);

    void addToBasket(int numberOfPerfomance, int numberUser);

    void addToBasket(int numberOfPerfomance, int numberUser, int numberTicket);

    void removeFromBasket(int numberTicket);

    List<Ticket> getAllFromBasket(int numberUser);

    void addNewOrder(User user);


}
