package library.model;

public class DigitalResource extends LibraryResource implements Printable {
    private String format;

    public DigitalResource(int resourceId, String title, String author, String format) {
        super(resourceId, title, author);
        this.format = format;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }

    @Override
    public void printDetails() {
        System.out.println("DigitalResource  [ID: " + getResourceId()
                + ", Title: " + getTitle()
                + ", Author: " + getAuthor()
                + ", Format: " + format + "]");
    }
}
