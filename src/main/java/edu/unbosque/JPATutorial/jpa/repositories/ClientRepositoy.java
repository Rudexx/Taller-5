package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoy {

    List<Customer> findAll();

    Optional<Customer> save(Customer cusomer);

    void deleteCustomer(String email);

    void modifyLibrary(String email, String last_name,String first_name, String gender, int age);
}
