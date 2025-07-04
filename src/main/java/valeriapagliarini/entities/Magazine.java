package valeriapagliarini.entities;


import jakarta.persistence.*;
import valeriapagliarini.enums.Period;

@Entity
@Table(name = "magazines")
public class Magazine extends CatalogElement {


    //devo specificare enumtype altrimenti nella tabella mi torna un int
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Period period;

    //costuttore vuoto
    public Magazine() {
    }

    // costruttore
    public Magazine(String isbn, String title, int publicationYear, int pages, Period period) {
        super(isbn, title, publicationYear, pages);
        this.period = period;
    }

    //getter setter
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
    //tostring


    @Override
    public String toString() {
        return "Magazine{" +
                "period=" + period +
                '}';
    }
}

