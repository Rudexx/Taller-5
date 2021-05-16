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



}
