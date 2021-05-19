package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Customer") // Optional
public class Customer {


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Rent> rentList;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Id
    @Column(name = "email")
    private String email;


    public Customer() { }

    public Customer(String email, String last_name,String first_name, String gender, int age) {
        this.age = age;
        this.email = email;
        this.lastName = last_name;
        this.firstName = first_name;
        this.gender = gender;
        rentList = new ArrayList<Rent>();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void addRent(Rent rent) {
        rent.setCustomer(this);
        this.rentList.add(rent);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "rentList=" + rentList +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
