package valeriapagliarini.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "expected_return_date")
    private LocalDate expectedReturnDate;

    @Column(name = "actual_return_date")
    private LocalDate actualReturnDate;

    //utente cha ha preso in prestito
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    //elemento prestato
    @ManyToOne
    @JoinColumn(name = "element_id", nullable = false)
    private CatalogElement catalogElement;

    //costruttore vuoto
    public Borrow() {
    }

    //costruttore
    public Borrow(User user, CatalogElement catalogElement, LocalDate startDate, LocalDate actualReturnDate) {
        this.user = user;
        this.catalogElement = catalogElement;
        this.startDate = LocalDate.now();
        this.expectedReturnDate = this.startDate.plusDays(30);
        // this.actualReturnDate = LocalDate.now();
    }

    //getter

    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }
    //setter

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CatalogElement getCatalogElement() {
        return catalogElement;
    }

    public void setCatalogElement(CatalogElement catalogElement) {
        this.catalogElement = catalogElement;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", actualReturnDate=" + actualReturnDate +
                ", user=" + user +
                ", catalogElement=" + catalogElement +
                '}';
    }
}
