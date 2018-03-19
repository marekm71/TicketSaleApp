package pl.first.project.springproject.model;

import javax.persistence.*;

@Table(name="bilet")
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_biletu")
    private int id;
    @ManyToOne
    @JoinColumn(name = "numer_wydarzenia", referencedColumnName = "id_wydarzenia")
    private Performance performance;
    @Column(name="czy_w_koszyku")
    private boolean inBasket;
    @ManyToOne
    @JoinColumn(name="w_koszyku_uzytkownika", referencedColumnName = "id_uzytkownika")
    private User user;
    @Column(name="czy_sprzedany")
    private boolean sold;
    @ManyToOne
    @JoinColumn(name="numer_zamowienia", referencedColumnName = "id_zamowienia")
    private Order order;

    public Ticket() {
        this.inBasket=false;
        this.sold=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public boolean isInBasket() {
        return inBasket;
    }

    public void setInBasket(boolean inBasket) {
        this.inBasket = inBasket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
