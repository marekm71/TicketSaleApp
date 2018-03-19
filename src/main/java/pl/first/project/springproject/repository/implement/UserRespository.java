package pl.first.project.springproject.repository.implement;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.first.project.springproject.model.*;
import pl.first.project.springproject.repository.UserRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class UserRespository implements UserRepositoryInterface{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createUser(String username, String password, String firstname, String lastname) {
        User user = new User(username,password, firstname, lastname);
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUser(String username) {
        return entityManager.createQuery("from User u where u.username=:username",User.class).setParameter("username",username).getSingleResult();
    }

    @Override
    @Transactional
    public void addToBasket(int numberOfPerfomance, int numberUser) {
        Performance performance = entityManager.find(Performance.class,numberOfPerfomance);
        User user = entityManager.find(User.class,numberUser);
        List<Ticket> ticketInPerformance = performance.getTickets();
        List<Ticket> ticketInUserBasket = user.getTicketsInBasket();
        boolean isSold = false;
        for(Ticket ticket : ticketInPerformance){
            if(!ticket.isInBasket() && !ticket.isSold() && !isSold){
                ticket.setInBasket(true);
                ticket.setUser(user);
                ticketInUserBasket.add(ticket);
                isSold=true;
            }
        }
    }

    @Override
    @Transactional
    public void addToBasket(int numberOfPerfomance, int numberUser, int numberTicket) {
        Performance performance = entityManager.find(Performance.class,numberOfPerfomance);
        User user = entityManager.find(User.class,numberUser);
        List<Ticket> ticketInPerformance = performance.getTickets();
        List<Ticket> ticketInUserBasket = user.getTicketsInBasket();
        boolean isSold = false;
        int i=0;
        for(Ticket ticket : ticketInPerformance){
            if(!ticket.isInBasket() && !ticket.isSold() && !isSold){
                ticket.setInBasket(true);
                ticket.setUser(user);
                ticketInUserBasket.add(ticket);
                i++;
                if(i==numberTicket) isSold=true;
            }
        }
    }

    @Override
    @Transactional
    public void removeFromBasket(int numberTicket) {
        Ticket ticket = entityManager.find(Ticket.class, numberTicket);
        User user = ticket.getUser();
        ticket.setInBasket(false);
        ticket.setUser(null);
        user.getTicketsInBasket().remove(ticket);
    }

    @Override
    public List<Ticket> getAllFromBasket(int numberUser){
        User user = entityManager.find(User.class,numberUser);
        return user.getTicketsInBasket();
    }

    @Override
    @Transactional
    public void addNewOrder(User user) {
        Order order = new Order();
        List<Order> orderList = user.getOrderList();
        order.setUserOrder(user);
        orderList.add(order);
        entityManager.persist(order);
        List<Ticket> ticketList = user.getTicketsInBasket();
        for(Ticket ticket : user.getTicketsInBasket()){
            ticket.setOrder(order);
            ticket.setInBasket(false);
            ticket.setSold(true);
            ticket.setUser(null);
        }
        user.setTicketsInBasket(new LinkedList<>());
        order.setTicketsInOrder(ticketList);
    }
}
