package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.jpa.entities.Rent;
import edu.unbosque.JPATutorial.jpa.repositories.LibraryRepository;
import edu.unbosque.JPATutorial.jpa.repositories.LibraryRepositoryImpl;
import edu.unbosque.JPATutorial.jpa.repositories.RentRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.Library_EditionPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.RentPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Stateless
public class RentService {

    private RentRepositoryImpl r;

    public List<RentPOJO> listRents() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        r = new RentRepositoryImpl(entityManager);
        List<Rent> rents = r.findAll();

        entityManager.close();
        entityManagerFactory.close();


        List<RentPOJO> rentPOJO = new ArrayList<>();
        for (Rent rent : rents) {


            rentPOJO.add(new RentPOJO(rent.getCustomer().getEmail()
            , rent.getEdition().getEditionId()
            , rent.getCustomer().getFirstName() + " " +rent.getCustomer().getLastName()
            , rent.getDate() ,
                    rent.getRentId()));
        }

        return rentPOJO;

    }

    public void saveRent(String email, int editionId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        r = new RentRepositoryImpl(entityManager);
        r.save(email, editionId);



        entityManager.close();
        entityManagerFactory.close();

        return;

    }



}

