package edu.unbosque.JPATutorial.servlets.pojos;

public class BookPOJO {

    private int bookId;

    private String authorName;

    private String title;

    private String isbnNumber;

    private String genre;

    private int editionNumber;

    private int authorId;





    public BookPOJO() { }

    public BookPOJO(int bookId,String authorName, String title, String isbnNumber, String genre, int editionNumber , int authorId) {
        this.bookId = bookId;
        this.authorName = authorName;
       this.title = title;
       this.isbnNumber = isbnNumber;
       this.genre = genre;
       this.editionNumber = editionNumber;
       this.authorId = authorId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
