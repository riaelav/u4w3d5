package valeriapagliarini.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends CatalogElement {

    @Column(nullable = false, length = 150)
    private String author;

    @Column(nullable = false, length = 100)
    private String genre;

    //costruttore vuoto
    public Book() {
    }

    //costruttore
    public Book(String isbn, String title, int publicationYear, int pages, String author, String genre) {
        super(isbn, title, publicationYear, pages);
        this.author = author;
        this.genre = genre;
    }


    //getter e setter


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //to string


    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                '}';
    }
}
