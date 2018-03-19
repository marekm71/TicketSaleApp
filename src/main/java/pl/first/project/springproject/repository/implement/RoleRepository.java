package pl.first.project.springproject.repository.implement;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.first.project.springproject.model.Role;
import pl.first.project.springproject.model.User;
import pl.first.project.springproject.repository.RoleRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleRepository implements RoleRepositoryInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createRole(String username, String rola) {
        Role role = new Role(username,rola);
        entityManager.persist(role);
    }

}
