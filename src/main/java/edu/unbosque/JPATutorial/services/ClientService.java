package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.JPATutorial.jpa.repositories.ClientRepositorylmpl;
import edu.unbosque.JPATutorial.jpa.repositories.ClientRepositoy;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.ClientPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class ClientService {

    ClientRepositoy clientRepositoy;

    public List<ClientPojo> listclients(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        clientRepositoy = new ClientRepositorylmpl(entityManager);
        List<Customer> customers = clientRepositoy.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<ClientPojo> clientPojos = new ArrayList<>();

        for (Customer customer : customers) {
            clientPojos.add(new ClientPojo(
                    customer.getEmail(),
                    customer.getLastName(),
                    customer.getFirstName(),
                    customer.getGender(),
                    customer.getAge()
            ));
        }
        ArrayList<String> Emails = new ArrayList<String>();
        for(int i = 0; i < clientPojos.size(); i++){
            Emails.add(clientPojos.get(i).getEmail());
        }
        List<ClientPojo> ordenada = new ArrayList<>();
        Collections.sort(Emails);
        for(int i= 0; i< clientPojos.size(); i++){
            for(int j = 0; j < clientPojos.size(); j++){
                if(Emails.get(i).equals(clientPojos.get(j).getEmail())){
                    ordenada.add(clientPojos.get(j));
                }
            }
        }
        clientPojos = ordenada;
        return clientPojos;

    }

    public Customer Crearcliente (String email, String first_name,String last_name, String gender, int age){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        clientRepositoy = new ClientRepositorylmpl(entityManager);

        Customer cliente = new Customer();
        cliente.setAge(age);
        cliente.setEmail(email);
        cliente.setFirstName(first_name);
        cliente.setLastName(last_name);
        cliente.setGender(gender);

        Customer persistedCustomer = clientRepositoy.save(cliente).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedCustomer;

    }

    public void deleteCustomer(String Email){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        clientRepositoy = new ClientRepositorylmpl(entityManager);
        clientRepositoy.deleteCustomer(Email);

        entityManager.close();
        entityManagerFactory.close();



    }

    public void modifyLibrary(String email, String last_name,String first_name, String gender, int age){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        clientRepositoy = new ClientRepositorylmpl(entityManager);
        clientRepositoy.modifyLibrary( email, last_name,first_name, gender, age);

        entityManager.close();
        entityManagerFactory.close();

    }

}
