package valeriapagliarini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String surname;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "card_number", nullable = false, length = 50)
    private String cardNumber;

    @OneToMany(mappedBy = "user")
    private List<Borrow> borrowings;

    //costruttori

    public User() {
    }

    public User(String name, String surname, LocalDate birthDate, String cardNumber) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.cardNumber = cardNumber;
    }

    //getter

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
//setter

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public List<Borrow> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrow> borrowings) {
        this.borrowings = borrowings;
    }


    //tostring

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
