package edu.unbosque.JPATutorial.jpa.entities;

import edu.unbosque.JPATutorial.jpa.entities.Edition;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Rent") // Optional
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private Integer rentId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "email")
    private Customer customer;

    @JoinColumn(name = "edition_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Edition edition;

    @Column(name = "renting_date")
    private String date;

    public Rent() { }

    public Rent(Integer libraryId, String name) {

    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
