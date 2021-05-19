package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class LibraryRepositoryImpl implements LibraryRepository {

    private EntityManager entityManager;

    public LibraryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Library> findAll() {
        return entityManager.createQuery("from Library ").getResultList();
    }

    @Override
    public Optional<Library> save(Library library) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(library);
            entityManager.getTransaction().commit();
            return Optional.of(library);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteLibrary(int id) {
        try {

            Library library= entityManager.find(Library.class, id);

            entityManager.getTransaction().begin();


            entityManager.remove(library);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyLibrary(int id, String name) {
        try {

            Library library= entityManager.find(Library.class, id);

            entityManager.getTransaction().begin();
            library.setName(name);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void associateEdition(int editionId, int libraryId) {

        try {

            Library library= entityManager.find(Library.class, libraryId);
            Edition edition = entityManager.find(Edition.class, editionId);
            entityManager.getTransaction().begin();

            library.addEdition(edition);
            edition.addLibrary(library);


            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    @Override
    public void DisassociateEdition(int editionId, int libraryId) {


        try {

            Library library= entityManager.find(Library.class, libraryId);
            Edition edition = entityManager.find(Edition.class, editionId);
            entityManager.getTransaction().begin();

            library.deleteEdition(edition);
            edition.deleteLibrary(library);


            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}
