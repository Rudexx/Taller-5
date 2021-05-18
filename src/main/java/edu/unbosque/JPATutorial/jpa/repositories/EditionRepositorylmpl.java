package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Edition;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Optional;


public class EditionRepositorylmpl  implements EditionRepository {
    private EntityManager entityManager;
    public EditionRepositorylmpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Optional<Edition> findById(Integer id) {
        Edition edition = entityManager.find(Edition.class, id);
        return edition != null ? Optional.of(edition) : Optional.empty();
    }

    @Override
    public Optional<Edition> findByDescription(String Description) {
        Edition edition = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :Description", Edition.class)
                .setParameter("Description", Description)
                .getSingleResult();
        return edition != null ? Optional.of(edition) : Optional.empty();
    }

    @Override
    public Optional<Edition> findByRelease_Year(Date Release_Year) {
        Edition edition = entityManager.createNamedQuery("Book.findByTitle", Edition.class)
                //arreglar el title y findByTitle
                .setParameter("title",Release_Year )
                .getSingleResult();
        return edition !=null ? Optional.of(edition): Optional.empty();
    }

    @Override
    public Optional<Edition> save(Edition edition) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(edition);
            entityManager.getTransaction().commit();
            return Optional.of(edition);
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Edition> modifyById(Integer editionId, String description, Date releaseYear) {
        try{
            Edition e =entityManager.find(Edition.class, editionId);
            entityManager.getTransaction().begin();
            e.setDescription(description);
            e.setReleaseYear(releaseYear);
            entityManager.getTransaction().commit();
            return Optional.of(e);
        }catch(Exception r){
            r.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(int editionId) {

        Edition edition = entityManager.find(Edition.class, editionId);
        if (edition != null) {

            try {
                entityManager.getTransaction().begin();

                for (int i = 0; i < edition.getEditionId(); i++) {
                    //en wait va remove
                    edition.getEditionId().wait(i);
                }

                entityManager.remove(edition);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}