package pl.first.project.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.first.project.springproject.model.Role;
import pl.first.project.springproject.repository.implement.RoleRepository;
import pl.first.project.springproject.services.PerformanceService;
import pl.first.project.springproject.services.RoleService;
import pl.first.project.springproject.services.UserService;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    PerformanceService performanceService;

    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        userService.createUserAdmin("admin","admin","admin_imie","admin_nazwisko");
        userService.createUser("user","user","imie","nazwisko");
        userService.createUser("user1","user1","imie1","nazwisko1");
        performanceService.createPerformance("WIEDŹMIN", LocalDateTime.of(2018,6,22,21,30),20);
        performanceService.createPerformance("PIOTRUŚ PAN", LocalDateTime.of(2018,8,22,19,30),10);
    }
}
