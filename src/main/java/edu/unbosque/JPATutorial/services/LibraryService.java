package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.jpa.repositories.LibraryRepository;
import edu.unbosque.JPATutorial.jpa.repositories.LibraryRepositoryImpl;

import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.Library_EditionPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Iterator;
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
                    library.getName(),
                    library.getEditions().size()
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
    public void changelibrary(String name, int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);


        libraryRepository.modifyLibrary(id , name);

        entityManager.close();
        entityManagerFactory.close();

        return;
    }

    public void assosiateEdition(int editionId, int libraryId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);


        libraryRepository.associateEdition(editionId,libraryId);

        entityManager.close();
        entityManagerFactory.close();

        return;



    }

    public void disEdition(int editionId, int libraryId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);


        libraryRepository.DisassociateEdition(editionId, libraryId);

        entityManager.close();
        entityManagerFactory.close();

        return;
    }

    public List<Library_EditionPOJO> listLibraryEditions(){


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);
        List<Library> libraries = libraryRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();





        List<Library_EditionPOJO> librariesPOJO = new ArrayList<>();
        for (Library library : libraries) {

            String edition = "";
            Iterator iterator = library.getEditions().iterator();

            // check values
            while (iterator.hasNext()){
                edition = iterator.next().toString();
                if(library.getEditions().size() != 0){
                    librariesPOJO.add(new Library_EditionPOJO(library.toString(), edition));
                }
            }


        }

        return librariesPOJO;
    }

}

