package pl.first.project.springproject.repository.implement;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.first.project.springproject.model.Performance;
import pl.first.project.springproject.model.Ticket;
import pl.first.project.springproject.repository.PerformanceRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public class PerfomanceRepostiory implements PerformanceRepositoryInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createPerformance(String title, LocalDateTime date, int numberOfTickets) {
        Performance performance = new Performance(title,date,numberOfTickets);
        List<Ticket> ticketList = performance.getTickets();
        for(int i=0; i<numberOfTickets; i++){
            Ticket ticket = new Ticket();
            ticket.setPerformance(performance);
            ticketList.add(ticket);
        }
        entityManager.persist(performance);
    }

    @Override
    @Transactional
    public void createPerformance(Performance performance) {
        List<Ticket> ticketList = performance.getTickets();
        int numberOfTickets = performance.getNumberTicketsAll();
        for(int i=0; i<numberOfTickets; i++){
            Ticket ticket = new Ticket();
            ticket.setPerformance(performance);
            ticketList.add(ticket);
        }
        entityManager.persist(performance);
    }

    @Override
    public List<Performance> getAllPerformance() {
        List<Performance> performanceList = entityManager.createQuery("from Performance").getResultList();
        return performanceList;
    }
}
