package edu.unbosque.JPATutorial.servlets.pojos;

public class EditionPOJO {

    private Integer editionId;

    private String description;

    private String bookName;

    public EditionPOJO() { }

    public EditionPOJO(Integer editionId, String description, String bookName) {
        this.editionId = editionId;
        this.description = description;
        this.bookName = bookName;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
