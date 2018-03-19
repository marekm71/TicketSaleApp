package pl.first.project.springproject.repository;

import pl.first.project.springproject.model.Performance;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PerformanceRepositoryInterface {
    void createPerformance(String title, LocalDateTime date, int numberOfTickets);

    void createPerformance(Performance performance);

    List<Performance> getAllPerformance();

}
