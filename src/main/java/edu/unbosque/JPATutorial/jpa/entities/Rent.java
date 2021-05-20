package edu.unbosque.JPATutorial.jpa.entities;

import edu.unbosque.JPATutorial.jpa.entities.Edition;

import javax.persistence.*;
import java.util.Date;
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private Customer customer;

    @JoinColumn(name = "edition_id")
    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Edition edition;

    @Column(name = "renting_date")
    private java.util.Date date;

    public Rent() { }

    public Rent(Customer c, Edition e, java.util.Date date) {
        this.customer = c;
        this.edition = e;
        this.date = date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void removeCustomer(){


        for (int i = 0; i <this.customer.getRentList().size() ; i++) {
            this.customer.getRentList().remove(i);
        }

        for (int i = 0; i <this.edition.getRent().size() ; i++) {
            this.edition.getRent().remove(i);
        }

        this.customer = null;
        this.edition = null;
    }

}
