import java.io.*;
import java.util.Scanner;

public class StudentFileManager {
    public static void writeStudents() {
        try (FileWriter writer = new FileWriter("students.txt")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details of Student " + (i + 1));
                System.out.print("Enter Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();
                sc.nextLine();
                writer.write("Roll Number: " + roll + "\n");
                writer.write("Name: " + name + "\n");
                writer.write("Marks: " + marks + "\n");
                writer.write("----------------------\n");
            }
            System.out.println("\nStudent records saved successfully.");
        }
        catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readStudents() {
        try (FileReader reader = new FileReader("students.txt")) {
            int ch;
            System.out.println("\n--- Student Records ---");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Student file not found.");
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void copyBinaryFile() {
        try (
            FileInputStream input = new FileInputStream("source.dat");
            FileOutputStream output = new FileOutputStream("copy.dat")
        ) {
            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
            System.out.println("\nBinary file copied successfully.");

        }
        catch (FileNotFoundException e) {
            System.out.println("Source binary file not found.");
        }
        catch (IOException e) {
            System.out.println("Error copying binary file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Student File Management System =====");
            System.out.println("1. Write Student Records");
            System.out.println("2. Read Student Records");
            System.out.println("3. Copy Binary File");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    writeStudents();
                    break;
                case 2:
                    readStudents();
                    break;
                case 3:
                    copyBinaryFile();
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);
        sc.close();
    }
}
