package pl.first.project.springproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;

@Table(name="wydarzenie")
@Entity
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_wydarzenia")
    private int id;
    @NotNull
    @Size(min = 1, max = 15, message = "Tytuł musi mieć co najmniej jeden znak")
    @Column(name="tytul_wydarzenia")
    private String title;
    @Column(name="data_wydarzenia")
    private LocalDateTime date;
    @Size(max=16, message = "Błędna data")
    @Column(name="data_wydarzenia_tekst")
    private String dateString;
    @Column(name="czy_zakonczono_wydarzenie")
    private boolean ended;
    @Column(name="liczba_miejsc_calkowicie")
    private int numberTicketsAll;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "performance")
    private List<Ticket> tickets;

    public Performance() {
        this.dateString=null;
        this.tickets = new LinkedList<>();
        this.ended=false;
    }

    public Performance(String title, LocalDateTime date, int numberTicketsAll) {
        this.dateString=null;
        this.numberTicketsAll = numberTicketsAll;
        this.title = title;
        this.date = date;
        this.ended = false;
        this.tickets = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getNumberTicketsAll() {
        return numberTicketsAll;
    }

    public void setNumberTicketsAll(int numberTicketsAll) {
        this.numberTicketsAll = numberTicketsAll;
    }

    public int getNumberFreeTicket(){
        int i=0;
        for(Ticket ticket : tickets){
            if(!ticket.isInBasket() && !ticket.isSold()){
                i++;
            }
        }
        return i;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
