package edu.unbosque.JPATutorial.servlets.pojos;

public class EditionPOJO {

    private Integer editionId;

    private String description;

    private String bookName;

    private int bookId;

    private String date;

    public EditionPOJO() { }

    public EditionPOJO(Integer editionId, String description, String bookName, int bookId, String date) {
        this.editionId = editionId;
        this.description = description;
        this.bookName = bookName;
        this.bookId = bookId;
        this.date = date;
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
