package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Edition") // Optional
@NamedQueries({
        @NamedQuery(name = "Edition.findAll",
                query = "SELECT b FROM Edition b")
})
public class Edition {

    @Id
    @GeneratedValue
    @Column(name = "edition_id")
    private Integer editionId;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private java.util.Date releaseYear;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edition", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Rent> rent;

    // FetchType.EAGER: When we retrieve a Library, we'll also automatically retrieve all of its corresponding Editions
    // CascadeType.PERSIST: When we save a superhero, its movies will also be saved
    @ManyToMany(mappedBy = "editions", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Library> libraries = new HashSet<>();

    public Edition() {}

    public Edition(String description, Date releaseYear) {
        this.description = description;
        this.releaseYear = releaseYear;
    }

    public Edition(Integer editionId, String description, Date releaseYear) {
        this.editionId = editionId;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<Library> getLibraries() {
        return libraries;
    }

    public void addLibrary(Library library) {
        library.getEditions().add(this);
        libraries.add(library);

    }
    public void deleteLibrary(Library library) {
        library.getEditions().remove(this);
        libraries.remove(library);

    }


    @Override
    public String toString() {
        return "Edition{" +
                "editionId=" + editionId +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", book=" + book +
                ", rent=" + rent +
                ", libraries=" + libraries +
                '}';
    }

    public List<Rent> getRent() {
        return rent;
    }


}
