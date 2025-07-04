package valeriapagliarini;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import valeriapagliarini.dao.CatalogElementsDAO;
import valeriapagliarini.entities.Book;

public class Application {
    //creo l'entity manager
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5pu");


    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CatalogElementsDAO cd = new CatalogElementsDAO(em);

        //libri
        Book b1 = new Book("978-0547928227", "Il Signore degli Anelli", 1954,
                576, "Tolkien", "Fantasy");

        Book b2 = new Book("978-8807815114", "Norwegian Wood", 1987,
                376, "Haruki Murakami", "Narrativa contemporanea");

        Book b3 = new Book("978-8893442332", "Se i gatti scomparissero dal mondo", 2012,
                170, "Genki Kawamura", "Romanzo filosofico");

        Book b4 = new Book("978-0006479888", "Game of Thrones", 1996,
                864, "George R.R. Martin", "Fantasy");

        Book b5 = new Book("978-8806218381", "Scarafaggi", 1998,
                352, "Jo Nesbo", "Thriller poliziesco");

        Book b6 = new Book("978-8861909733", "Pura Vida", 2003,
                180, "Gianluca Gotto", "Romanzo di viaggio");
        //SAVE TEST
       /* cd.save(b1);
        cd.save(b2);
        cd.save(b3);
        cd.save(b4);
        cd.save(b5);
        cd.save(b6);*/
        //FIND TEST
       /* CatalogElement foundElement = cd.findById(2L);
        System.out.println("Elemento trovato nel catalogo:");
        System.out.println(foundElement);*/

        em.close();
        emf.close();


    }
}
