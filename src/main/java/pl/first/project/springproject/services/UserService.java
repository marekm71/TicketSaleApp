package pl.first.project.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.first.project.springproject.model.Order;
import pl.first.project.springproject.model.Role;
import pl.first.project.springproject.model.Ticket;
import pl.first.project.springproject.model.User;
import pl.first.project.springproject.repository.implement.RoleRepository;
import pl.first.project.springproject.repository.implement.UserRespository;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRespository userRespository;

    @Autowired
    RoleService roleService;

    public void createUserAdmin(String username, String password, String firstname, String lastname) {
        userRespository.createUser(username, password, firstname, lastname);
        roleService.createRole(username,"ADMIN");
    }

    public void createUser(String username, String password, String firstname, String lastname) {
        userRespository.createUser(username, password, firstname, lastname);
        roleService.createRole(username,"USER");
    }

    public User findUser(String username) {
        return userRespository.findUser(username);
    }

    public void createUser(User user) {
        userRespository.createUser(user);
        roleService.createRole(user.getUsername(),"USER");
    }

    public void addToBasket(int numberOfPerfomance, int numberUser) {
        userRespository.addToBasket(numberOfPerfomance, numberUser);
    }

    public void addToBasket(int numberOfPerfomance, int numberUser, int numberTicket) {
        userRespository.addToBasket(numberOfPerfomance, numberUser, numberTicket);
    }

    public List<Ticket> getAllFromBasket(int numberUser) {
        return userRespository.getAllFromBasket(numberUser);
    }

    public void removeFromBasket(int numberTicket) {
        userRespository.removeFromBasket(numberTicket);
    }

    public void addNewOrder(User user) {
        userRespository.addNewOrder(user);
    }


}