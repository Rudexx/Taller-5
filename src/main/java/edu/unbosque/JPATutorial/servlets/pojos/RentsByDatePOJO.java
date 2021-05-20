package edu.unbosque.JPATutorial.servlets.pojos;

public class RentsByDatePOJO {

    private String email;

    private int editionId;

    private String customerName;

    private java.util.Date rentingDate;

    private int rentId;

    public RentsByDatePOJO(String email, int editionId, String customerName, java.util.Date rentingDate, int rentId){
        this.email = email;
        this.editionId = editionId;
        this.customerName = customerName;
        this.rentingDate = rentingDate;
        this.rentId = rentId;
    }

    @Override
    public String toString() {
        return "Email: " + email + "\n" +
                "EditionId: " + editionId +  "\n" +
                "CustomerName: '" + customerName + "\n" +
                "RentingDate: " + rentingDate + "\n" +
                "RentId: " + rentId;
    }
}
