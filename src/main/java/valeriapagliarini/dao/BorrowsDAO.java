package valeriapagliarini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import valeriapagliarini.entities.Borrow;

public class BorrowsDAO {

    private final EntityManager em;

    public BorrowsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Borrow borrow) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(borrow);
        transaction.commit();
        System.out.println("Borrow saved with ID: " + borrow.getId());
    }
}
