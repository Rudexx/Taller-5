package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.jpa.repositories.*;

import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Stateless
public class EditionService {

    EditionRepository editionRepository;
    public void saveEdition(Integer editionId, String description, Date releaseYear) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositorylmpl(entityManager);


        Optional<Edition> edition = editionRepository.findById(editionId);



        entityManager.close();
        entityManagerFactory.close();

        return;

    }

    public void deleteBook(int editionId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositorylmpl(entityManager);
        editionRepository.deleteById(editionId);

        entityManager.close();
        entityManagerFactory.close();
    }



    public void modifyEdition(Integer editionId, String description, Date releaseYear) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositorylmpl(entityManager);
        editionRepository.modifyById(editionId,description, releaseYear);

        entityManager.close();
        entityManagerFactory.close();
    }
}
