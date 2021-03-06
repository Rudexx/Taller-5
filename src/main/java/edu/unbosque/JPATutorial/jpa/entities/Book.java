package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Book") // Optional
@NamedQueries({
        @NamedQuery(name = "Book.findByTitle",
                query = "SELECT b FROM Book b WHERE b.title = :title"),
        @NamedQuery(name = "Book.findAll",
                query = "SELECT b FROM Book b"),
})
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private int bookId;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(name = "isbn_number")
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Edition> edition;

    @Column(name = "genre")
    private String genre;

    public Book() {}

    public Book(String title, String isbn, String genre, Edition edition) {
        this.edition = new ArrayList<>();
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        edition.setBook(this);
        this.edition.add(edition);
    }

    public Book(Integer bookId, String title, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;

    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Edition> getEdition() { return edition; }

    public void addEdition(Edition edition) {
        edition.setBook(this);
        this.edition.add(edition);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
