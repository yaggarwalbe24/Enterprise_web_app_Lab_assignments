package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.LibraryService;
import library.util.InputValidator;

public class Main {
    public static void main(String[] args) {
        LibraryResource[] resources = {
            new Book(101, "Clean Code", "Robert Martin", "978-0132350884"),
            new Book(102, "Effective Java", "Joshua Bloch", "978-0134685991"),
            new DigitalResource(201, "Java Tutorial", "Oracle Docs", "PDF"),
            new DigitalResource(202, "Data Structures Notes", "MIT OCW", "Video"),
            new Book(103, "Head First Java", "Sierra & Bates", "978-0596009205")
        };
        int[] overdueDays = { 4, 0, 7, 2, 1 };

        System.out.println("Library : " + LibraryResource.getLibraryName());
        System.out.println();

        LibraryService service = new LibraryService(resources.length);
        int valid = 0;
        for (int i = 0; i < resources.length; i++) {
            if (InputValidator.validateResourceId(resources[i].getResourceId())
                    && InputValidator.validateFineDays(overdueDays[i])) {
                service.addResource(resources[i], overdueDays[i]);
                valid++;
            } else {
                System.out.println("Invalid resource skipped: " + resources[i].getResourceId());
            }
        }
        System.out.println(valid + "/" + resources.length + " resources passed validation.");
        System.out.println();

        service.displayAllResources();
        System.out.println();
        System.out.println("Total fine of all overdue resources: Rs. " + service.calculateTotalFine());
        System.out.println();
        LibraryResource.displayTotalResources();
    }
}
