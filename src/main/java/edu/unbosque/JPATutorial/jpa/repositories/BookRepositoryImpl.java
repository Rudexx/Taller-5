package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    private EntityManager entityManager;

    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Book> findById(Integer id) {
        Book book = entityManager.find(Book.class, id);
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public Optional<Book> findByTitle(String title) {
        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public Optional<Book> findByNameNamedQuery(String title) {
        Book book = entityManager.createNamedQuery("Book.findByTitle", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public List<Book> findAll() {
        return entityManager.createQuery("from Book").getResultList();
    }

    public Optional<Edition> save(Edition edition) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(edition);
            entityManager.getTransaction().commit();
            return Optional.of(edition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Book> modifyById(Integer id, String title, String isbn, String genre) {

        try {
            Book a = entityManager.find(Book.class, id);
            entityManager.getTransaction().begin();
            a.setTitle(title);
            a.setIsbn(isbn);
            a.setGenre(genre);
            entityManager.getTransaction().commit();
            return Optional.of(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();


    }

    @Override
    public List<Edition> findEditions() {


        return null;
    }

    @Override
    public void deleteEdition(int editionId, int bookId) {


        Book book = entityManager.find(Book.class, bookId);
        if (book != null) {
            try {

                entityManager.getTransaction().begin();

                Edition b = null;

                for (int i = 0; i < book.getEdition().size(); i++) {
                    if (book.getEdition().get(i).getEditionId() == editionId) {
                        book.getEdition().remove(i);
                        System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    }
                }

                entityManager.remove(entityManager.find(Edition.class, editionId));
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }
}
