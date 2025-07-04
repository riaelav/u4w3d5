package valeriapagliarini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import valeriapagliarini.entities.User;
import valeriapagliarini.exceptions.NotFoundException;

public class UsersDAO {

    private final EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User newUser) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newUser);
        transaction.commit();
        System.out.println("User saved: " + newUser.getId());
    }

    public User findById(Long id) {
        User user = em.find(User.class, id);
        if (user == null) throw new NotFoundException("User ID " + id + " not found");
        return user;
    }


}
