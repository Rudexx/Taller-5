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
    public Optional<Edition> modifyEdition(String desc, java.util.Date date, int editionId) {

        try {
            Edition a = entityManager.find(Edition.class, editionId);
            entityManager.getTransaction().begin();
            a.setDescription(desc);
            a.setReleaseYear(date);
            entityManager.getTransaction().commit();
            return Optional.of(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }
}
