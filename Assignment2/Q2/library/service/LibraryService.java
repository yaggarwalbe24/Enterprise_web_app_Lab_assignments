package library.service;

import library.model.LibraryResource;
import library.model.Printable;

public class LibraryService {
    private LibraryResource[] resources;
    private int[] overdueDays;
    private int count;

    public LibraryService(int capacity) {
        resources = new LibraryResource[capacity];
        overdueDays = new int[capacity];
        count = 0;
    }

    public void addResource(LibraryResource resource, int overdueDays) {
        resources[count] = resource;
        this.overdueDays[count] = overdueDays;
        count++;
    }

    public void displayAllResources() {
        for (int i = 0; i < count; i++) {
            ((Printable) resources[i]).printDetails();
        }
    }

    public double calculateTotalFine() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            if (overdueDays[i] > 0) {
                total += resources[i].calculateFine(overdueDays[i]);
            }
        }
        return total;
    }
}
