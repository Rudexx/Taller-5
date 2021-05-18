package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.jpa.repositories.LibraryRepository;
import edu.unbosque.JPATutorial.jpa.repositories.LibraryRepositoryImpl;

import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LibraryService {

    LibraryRepository libraryRepository;

    public List<LibraryPOJO> listLibraries() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);
        List<Library> libraries = libraryRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<LibraryPOJO> librariesPOJO = new ArrayList<>();
        for (Library library : libraries) {
            librariesPOJO.add(new LibraryPOJO(
                    library.getLibraryId(),
                    library.getName()
            ));
        }

        return librariesPOJO;

    }

    public void saveLibrary(String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);

        Library library = new Library(name);
        Library persistedLibrary = libraryRepository.save(library).get();

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

    public void deletelibrary(int id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);


        libraryRepository.deleteLibrary(id);

        entityManager.close();
        entityManagerFactory.close();

        return;


    }
    public void changelibrary(String named, String name){
        for(int i = 0; i < libraryRepository.findAll().size();i++) {
            if(named.equals(libraryRepository.findAll().get(i).getName())) {
                libraryRepository.findAll().get(i).setName(name);
            }
        }
    }

}
