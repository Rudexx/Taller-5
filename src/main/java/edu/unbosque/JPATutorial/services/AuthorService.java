package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepository;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Stateless
public class AuthorService {

    AuthorRepository authorRepository;

    public List<AuthorPOJO> listAuthors() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        List<Author> authors = authorRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<AuthorPOJO> authorsPOJO = new ArrayList<>();

        for (Author author : authors) {
            authorsPOJO.add(new AuthorPOJO(
                    author.getAuthorId(),
                    author.getName(),
                    author.getBooks().size(),
                    author.getCountry()
            ));
        }
        ArrayList<Integer> IDs = new ArrayList<Integer>();
        for(int i = 0; i < authorsPOJO.size(); i++){
            IDs.add(authorsPOJO.get(i).getAuthorId());
        }
        List<AuthorPOJO> ordenada = new ArrayList<>();
        Collections.sort(IDs);
        for(int i= 0; i< authorsPOJO.size(); i++){
            for(int j = 0; j < authorsPOJO.size(); j++){
            if(IDs.get(i).equals(authorsPOJO.get(j).getAuthorId())){
                ordenada.add(authorsPOJO.get(j));
            }
            }
        }
        authorsPOJO = ordenada;
        return authorsPOJO;

    }

    public Author saveAuthor(String name, String country) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);

        Author author = new Author(name, country);
        Author persistedAuthor = authorRepository.save(author).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedAuthor;

    }

    public void deleteAuthor(Integer authorId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        authorRepository.deleteById(authorId);

        entityManager.close();
        entityManagerFactory.close();

    }

    public void modifyAuthor(Integer authorId, String name, String country){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        authorRepository.modifyById(authorId, name, country);

        entityManager.close();
        entityManagerFactory.close();
    }

}

