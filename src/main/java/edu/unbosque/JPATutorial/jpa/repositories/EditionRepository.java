package edu.unbosque.JPATutorial.jpa.repositories;


import edu.unbosque.JPATutorial.jpa.entities.Edition;

import java.util.Date;
import java.util.Optional;

public interface EditionRepository {
    Optional<Edition> findById(Integer id);
    Optional<Edition> findByDescription(String Description);
    Optional<Edition> findByRelease_Year(Date Release_Year);
    Optional<Edition> save(Edition edition);
    Optional<Edition> modifyById(Integer editionId, String description, Date releaseYear);
    void deleteById(int EditionId);

}



