package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Library;

import java.util.List;
import java.util.Optional;

public interface EditionRepository {

    List<Edition> findAll();

    Optional<Edition> save(Edition edition);

    void deleteLibrary(int id);

    void modifyLibrary(int id, String name);

}
