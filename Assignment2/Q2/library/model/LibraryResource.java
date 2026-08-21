package library.model;

public abstract class LibraryResource {
    private int resourceId;
    private String title;
    private String author;

    private static String libraryName = "Central University Library";
    private static int totalResources = 0;

    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        totalResources++;
    }

    public abstract double calculateFine(int overdueDays);

    public int getResourceId() {
        return resourceId;
    }

    protected String getTitle() {
        return title;
    }

    protected String getAuthor() {
        return author;
    }

    public static String getLibraryName() {
        return libraryName;
    }

    public static int getTotalResources() {
        return totalResources;
    }

    public static void displayTotalResources() {
        System.out.println("Total resources created: " + totalResources);
    }
}
