package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class EditionRepositoryImpl implements EditionRepository {

    private EntityManager entityManager;

    public EditionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Edition> findAll() {
        return entityManager.createQuery("from Edition").getResultList();
    }

    @Override
    public Optional<Edition> save(Edition edition) {
        return Optional.empty();
    }

    @Override
    public void deleteLibrary(int id) {

    }

    @Override
    public void modifyLibrary(int id, String name) {

    }
}
