package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Rent;

import java.util.List;
import java.util.Optional;

public interface RentRepository {



    List<Rent> findAll();

    Optional<Rent> save(String email, int editionId);



}
