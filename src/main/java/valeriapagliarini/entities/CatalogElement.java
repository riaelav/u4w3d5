package valeriapagliarini.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "catalog_element")

public abstract class CatalogElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false, unique = true, length = 30)
    protected String isbn;

    @Column(nullable = false, length = 300)
    protected String title;

    @Column(name = "pubblication_year", nullable = false)
    protected int publicationYear;

    @Column(name = "numb_pages")
    protected int pages;

    //costruttore vuoto obbligatorio
    public CatalogElement() {
    }

    //costruttore

    public CatalogElement(String isbn, String title, int publicationYear, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pages = pages;
    }

    //getter


    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // setter

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "CatalogElement{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                '}';
    }
}
