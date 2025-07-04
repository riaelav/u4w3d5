package valeriapagliarini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import valeriapagliarini.entities.Book;
import valeriapagliarini.entities.CatalogElement;
import valeriapagliarini.exceptions.NotFoundException;

import java.util.List;

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

    //QUERY PER RICERCA BY ISBN
    public CatalogElement findByIsbn(String isbn) {
        TypedQuery<CatalogElement> query = entityManager.createQuery(
                "SELECT e FROM CatalogElement e WHERE e.isbn = :isbn", CatalogElement.class);
        query.setParameter("isbn", isbn);

        return query.getSingleResult();
    }

    //QUERY DELETE BY ISBN
    public void deleteByIsbn(String isbn) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("DELETE FROM CatalogElement e WHERE e.isbn = :isbn");
        query.setParameter("isbn", isbn);

        transaction.commit();

        System.out.println(" element with ISBN " + isbn + " deleted.");
    }

    //QUERY FIND BY PUBBLICATION YEAR
    public List<CatalogElement> findElementByYear(int year) {
        TypedQuery<CatalogElement> query = entityManager.createQuery("SELECT e FROM CatalogElement e WHERE e.publicationYear =" +
                " :year", CatalogElement.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    //QUERY FIND BY AUTHOR

    public List<Book> findBookByAuthor(String author) {
        TypedQuery<Book> query = entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.author = :author", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    //FIND BY TITLE (TO FIX!! non è case sensitive)
    public List<CatalogElement> findByTitle(String title) {
        TypedQuery<CatalogElement> query = entityManager.createQuery(
                "SELECT e FROM CatalogElement e WHERE e.title = :title", CatalogElement.class);
        query.setParameter("title", title);
        return query.getResultList();
    }


}
