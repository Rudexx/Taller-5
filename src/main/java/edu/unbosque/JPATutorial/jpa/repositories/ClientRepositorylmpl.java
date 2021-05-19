package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Customer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ClientRepositorylmpl implements ClientRepositoy {

    private EntityManager entityManager;

    public ClientRepositorylmpl(EntityManager entityManager){

        this.entityManager = entityManager;

    }

    public Optional<Customer> findbyemail(String email){
        Customer customer = entityManager.find(Customer.class, email);
        return  customer != null ? Optional.of(customer) : Optional.empty();

    }

    public Optional<Customer> findByfirstname(String name) {
        Customer customer = entityManager.createQuery("SELECT b FROM Customer b WHERE b.firstName = : firstname", Customer.class)
                .setParameter("firstname", name)
                .getSingleResult();
        return  customer != null ? Optional.of(customer) : Optional.empty();
    }

    public Optional<Customer> findBylastname(String name) {
        Customer customer = entityManager.createQuery("SELECT b FROM Customer b WHERE b.lastName = : lastName", Customer.class)
                .setParameter("lastName", name)
                .getSingleResult();
        return  customer != null ? Optional.of(customer) : Optional.empty();
    }

    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer").getResultList();

    }

    @Override
    public Optional<Customer> save(Customer cusomer) {
        return Optional.empty();
    }

    @Override
    public void deleteCustomer(String email) {

    }

    @Override
    public void modifyLibrary(String email, String last_name, String first_name, String gender, int age) {

    }

}
