package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.repositories.*;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.EditionPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class EditionService {


    BookRepository bookRepository;
    private Object EditionRepository;

    public void saveEdition(int bookId, java.util.Date year , String desc) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EditionRepository = new EditionRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        Optional<Book> book = bookRepository.findById(bookId);
        book.ifPresent(a -> {
            Edition e = new Edition(desc,year);
            a.addEdition(e);
            bookRepository.save(e);
        });



        entityManager.close();
        entityManagerFactory.close();

        return;

    }

    public void deleteEdition(int bookId, int authorId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        authorRepository = new AuthorRepositoryImpl(entityManager);
//        authorRepository.deleteBook(authorId, bookId);

        entityManager.close();
        entityManagerFactory.close();
    }

    public List<EditionPOJO> listEditions() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EditionRepository e = new EditionRepositoryImpl(entityManager);
        List<Edition> editions = e.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<EditionPOJO> editionsPOJO = new ArrayList<>();
        for (Edition edition : editions) {
            editionsPOJO.add( new EditionPOJO( edition.getEditionId()
            , edition.getDescription()
            , edition.getBook().getTitle()));
        }

        return editionsPOJO;

    }

    public void modifyEdition(String title, String isbn, Integer bookId, String genre) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        bookRepository.modifyById(bookId,title, isbn,genre);

        entityManager.close();
        entityManagerFactory.close();
    }
}
