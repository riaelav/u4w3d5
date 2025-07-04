package valeriapagliarini;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import valeriapagliarini.dao.CatalogElementsDAO;
import valeriapagliarini.dao.UsersDAO;
import valeriapagliarini.entities.Book;
import valeriapagliarini.entities.Magazine;
import valeriapagliarini.entities.User;
import valeriapagliarini.enums.Period;

import java.time.LocalDate;

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


        //magazine

        CatalogElementsDAO md = new CatalogElementsDAO(em);

        Magazine m1 = new Magazine("977-1234567001", "Rolling Stone",
                2025, 90, Period.MONTHLY);

        Magazine m2 = new Magazine("977-1234567002", "Kite surf World",
                2025, 60, Period.MONTHLY);

        Magazine m3 = new Magazine("977-1234567003", "Climbing",
                2025, 72, Period.MONTHLY);

        Magazine m4 = new Magazine(
                "977-1234567004", "Internazionale", 2025,
                120, Period.WEEKLY);

        Magazine m5 = new Magazine("977-1234567005", "Waves",
                2025, 64, Period.SEMIANNUAL);


        //utenti
        UsersDAO ud = new UsersDAO(em);

        User u1 = new User("Aldo", "Baglio", LocalDate.of(1980, 5, 15),
                "TESS001");
        User u2 = new User("Giovanni", "Storti", LocalDate.of(1978, 8, 4)
                , "TESS002");
        User u3 = new User("Giacomo", "Poretti", LocalDate.of(1970, 2, 20),
                "TESS003");
        User u4 = new User("Valentina", "Bianchi", LocalDate.of(1990, 6, 25),
                "TESS004");
        User u5 = new User("Francesco", "Rossi", LocalDate.of(1988, 11, 8),
                "TESS005");


        //SAVE TEST
        /*
         cd.save(b1);
        md.save(m1);
        ud.save(u1);
        */


        //FIND TEST
       /* CatalogElement foundElement = cd.findById(2L);
        System.out.println("Elemento trovato nel catalogo:");
        System.out.println(foundElement);*/

        em.close();
        emf.close();


    }
}
