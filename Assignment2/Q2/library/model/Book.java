package library.model;

public class Book extends LibraryResource implements Printable {
    private String isbn;

    public Book(int resourceId, String title, String author, String isbn) {
        super(resourceId, title, author);
        this.isbn = isbn;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 5.0;
    }

    @Override
    public void printDetails() {
        System.out.println("Book             [ID: " + getResourceId()
                + ", Title: " + getTitle()
                + ", Author: " + getAuthor()
                + ", ISBN: " + isbn + "]");
    }
}
