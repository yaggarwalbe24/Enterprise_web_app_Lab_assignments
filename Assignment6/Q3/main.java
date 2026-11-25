import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int employeeId;
    String name;
    String department;
    double salary;
    Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("-------------------------");
    }
}

public class EmployeeSerialization {
    public static void saveEmployees(ArrayList<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(employees);
            System.out.println("\nEmployee records saved successfully.");
        }
        catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }

    public static void readEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            ArrayList<Employee> employees = (ArrayList<Employee>) ois.readObject();
            System.out.println("\n--- Employee Records ---");
            for (Employee emp : employees) {
                emp.display();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Employee file not found.");
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("Employee class not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Employee " + (i + 1));
            System.out.print("Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Department: ");
            String department = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            employees.add(new Employee(id, name, department, salary));
        }

        saveEmployees(employees);
        readEmployees();
        sc.close();
    }
}
