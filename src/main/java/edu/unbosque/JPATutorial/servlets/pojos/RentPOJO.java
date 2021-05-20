package edu.unbosque.JPATutorial.servlets.pojos;

public class RentPOJO {

    private String email;

    private int editionId;

    private String customerName;

    private java.util.Date rentingDate;

    private int rentId;

    public RentPOJO(String email, int editionId, String customerName, java.util.Date rentingDate, int rentId){
        this.email = email;
        this.editionId = editionId;
        this.customerName = customerName;
        this.rentingDate = rentingDate;
        this.rentId = rentId;
    }
}
