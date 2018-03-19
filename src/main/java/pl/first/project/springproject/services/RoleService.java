package pl.first.project.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.first.project.springproject.model.Role;
import pl.first.project.springproject.repository.implement.RoleRepository;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public void createRole(String username, String role){
        roleRepository.createRole(username, role);
    }
}
