package pl.first.project.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.first.project.springproject.model.Performance;
import pl.first.project.springproject.repository.implement.PerfomanceRepostiory;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    PerfomanceRepostiory perfomanceRepostiory;

    public void createPerformance(String title, LocalDateTime date, int numberTickets){
        perfomanceRepostiory.createPerformance(title,date,numberTickets);
    }

    public void createPerformance(Performance performance){
        perfomanceRepostiory.createPerformance(performance);
    }

    public List<Performance> getAllPerformance(){
        return perfomanceRepostiory.getAllPerformance();
    }

}
