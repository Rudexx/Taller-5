package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.entities.Rent;

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
    public Optional<Customer> save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return Optional.of(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteCustomer(String email) {

        Customer c = entityManager.find(Customer.class , email);

        if (c != null) {
            try {

                entityManager.getTransaction().begin();

                Rent r = null;

                for (int i = 0; i < c.getRentList().size(); i++) {

                    c.getRentList().remove(i);
                    entityManager.remove(c.getRentList().get(i));
                }



                entityManager.remove(c);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void modifyCustomer(String last_name, String first_name, String gender, int age ,String oldEmail) {

        Customer c = entityManager.find(Customer.class , oldEmail);
        System.out.println(c.toString());


            try {
                entityManager.getTransaction().begin();

                c.setAge(age);
                c.setFirstName(first_name);
                c.setLastName(last_name);
                c.setGender(gender);



                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }



    }

}
