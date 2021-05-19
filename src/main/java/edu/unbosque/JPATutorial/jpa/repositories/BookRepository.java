package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Optional<Book> findById(Integer id);

    Optional<Book> findByTitle(String title);

    Optional<Book> findByNameNamedQuery(String title);

    List<Book> findAll();

    Optional<Edition> save(Edition edition);

    Optional<Book> modifyById(Integer id, String title, String isbn ,String genre);

    List<Edition> findEditions();


}
