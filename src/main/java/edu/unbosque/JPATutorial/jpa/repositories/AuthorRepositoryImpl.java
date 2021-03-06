package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl implements AuthorRepository {

    private EntityManager entityManager;

    public AuthorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Author> findById(Integer id) {
        Author author = entityManager.find(Author.class, id);
        return author != null ? Optional.of(author) : Optional.empty();
    }

    public List<Author> findAll() {
        return entityManager.createQuery("from Author").getResultList();
    }

    public Optional<Author> findByName(String name) {
        Author author = entityManager.createNamedQuery("Author.findByName", Author.class)
                .setParameter("name", name)
                .getSingleResult();
        return author != null ? Optional.of(author) : Optional.empty();
    }

    public Optional<Author> save(Author author) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(author);
            entityManager.getTransaction().commit();
            return Optional.of(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
        Author author = entityManager.find(Author.class, id);
        if (author != null) {
            try {

                entityManager.getTransaction().begin();

                author.getBooks().forEach(book -> {
                    entityManager.remove(book);
                });



                entityManager.remove(author);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Optional<Author> modifyById(Integer id, String name, String country) {

        try {
            Author a = entityManager.find(Author.class, id);
            entityManager.getTransaction().begin();
            a.setName(name);
            a.setCountry(country);
            entityManager.getTransaction().commit();
            return Optional.of(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();



    }

    @Override
    public void deleteBook(Integer id, Integer bookId) {

        Author author = entityManager.find(Author.class, id);
        if (author != null) {
            try {

                entityManager.getTransaction().begin();

                Book b = null;

                for (int i = 0; i < author.getBooks().size(); i++) {
                    if(author.getBooks().get(i).getBookId() == bookId){
                        author.getBooks().remove(i);
                    }
                }

                entityManager.remove(entityManager.find(Book.class , bookId));
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    }


}
