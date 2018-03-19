package pl.first.project.springproject.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Table(name="zamowienie")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_zamowienia")
    private int id;
    @Column(name="data_zamowienia")
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name="zamowienie_uzytkownika", referencedColumnName = "id_uzytkownika")
    private User userOrder;
    @OneToMany(mappedBy = "order")
    private List<Ticket> ticketsInOrder;

    public Order() {
        this.date=LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(User userOrder) {
        this.userOrder = userOrder;
    }

    public List<Ticket> getTicketsInOrder() {
        return ticketsInOrder;
    }

    public void setTicketsInOrder(List<Ticket> ticketsInOrder) {
        this.ticketsInOrder = ticketsInOrder;
    }
}
