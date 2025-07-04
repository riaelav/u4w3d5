package valeriapagliarini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import valeriapagliarini.entities.CatalogElement;
import valeriapagliarini.exceptions.NotFoundException;

public class CatalogElementsDAO {

    //attributo
    private final EntityManager entityManager;

    //costruttore
    public CatalogElementsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public void save(CatalogElement element) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(element);
        transaction.commit();
        System.out.println("Element with ID " + element.getId() + " saved");
    }

    // FIND BY ID
    public CatalogElement findById(Long id) {
        CatalogElement found = entityManager.find(CatalogElement.class, id);
        if (found == null) throw new NotFoundException("Element with" + id + " not found");
        return found;
    }
}
