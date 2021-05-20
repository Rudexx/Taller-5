package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.*;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RentRepositoryImpl implements RentRepository {

    private EntityManager entityManager;

    public RentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public List<Rent> findAll() {
        return entityManager.createQuery("from Rent").getResultList();
    }



    public Optional<Rent> save(String email, int editionId) {
        try {

            Customer c =entityManager.find(Customer.class, email);
            Edition e= entityManager.find(Edition.class, editionId);

            Date date = new Date();

            entityManager.getTransaction().begin();

            Rent r = new Rent(c,e, date);

            entityManager.persist(r);
            entityManager.getTransaction().commit();
            return Optional.of(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }




    }



