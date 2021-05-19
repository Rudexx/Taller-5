package edu.unbosque.JPATutorial.servlets.pojos;

public class LibraryPOJO {

    private Integer libraryId;

    private String name;

    private int editionNumber;


    public LibraryPOJO() { }

    public LibraryPOJO(Integer libraryId, String name, int editionNumber) {
        this.libraryId = libraryId;
        this.name = name;
        this.editionNumber = editionNumber;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
