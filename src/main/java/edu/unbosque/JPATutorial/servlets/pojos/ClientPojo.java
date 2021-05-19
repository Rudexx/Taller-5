package edu.unbosque.JPATutorial.servlets.pojos;

public class ClientPojo {

    private String Email;

    private String first_name;

    private String last_name;

    private String gender;

    private int edad;

    public ClientPojo(String email, String last_name,String first_name, String gender, int age){
        Email = email;
        this.last_name = last_name;
        this.first_name = first_name;
        this.gender = gender;
        edad = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
