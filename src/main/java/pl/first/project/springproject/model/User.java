package pl.first.project.springproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Table(name="uzytkownik")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_uzytkownika")
    private int id;
    @NotNull
    @Size(min = 4, max = 15, message = "Login musi być dłuższy niż 4 znaków a krótszy niż 15")
    @Column(name="login_uzytkownika")
    private String username;
    @NotNull
    @Size(min = 4, message = "Hasło musi mieć co najmniej 4 znaków")
    @Column(name="haslo_uzytkownika")
    private String password;
    @NotNull
    @Size(min = 1, message = "Imię musi zawierać co najmniej jeden znak")
    @Column(name="imie_uzytkownika")
    private String firstname;
    @NotNull
    @Size(min = 1, message = "Nazwisko musi zawierać co najmniej jeden znak")
    @Column(name="nazwisko_uzytkownika")
    private String lastname;
    @Column(name="czy_wlaczony_uzytkownik")
    private boolean enabled;
    @OneToMany(mappedBy = "userOrder")
    private List<Order> orderList;
    @OneToMany(mappedBy = "user")
    private List<Ticket> ticketsInBasket;

    public User() {
        this.enabled=true;
        this.ticketsInBasket=new LinkedList<>();
    }

    public User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.enabled=true;
        this.ticketsInBasket=new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Ticket> getTicketsInBasket() {
        return ticketsInBasket;
    }

    public void setTicketsInBasket(List<Ticket> ticketsInBasket) {
        this.ticketsInBasket = ticketsInBasket;
    }

}
