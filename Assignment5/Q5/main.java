import java.util.Optional;
import java.util.Objects;

class GenericUtility {

    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }
    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }
    public static <T extends Comparable<T>> T max(T a, T b) {
        return (a.compareTo(b) >= 0) ? a : b;
    }
    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Are strings equal? " + GenericUtility.isEqual("Java", "Java"));
        System.out.println("Are integers equal? " + GenericUtility.isEqual(10, 20));

        Optional<String> name = Optional.of("Rahul");
        Optional<String> emptyName = Optional.empty();

        System.out.println("\nName: " + GenericUtility.getDefault(name, "Unknown"));
        System.out.println("Default Name: " + GenericUtility.getDefault(emptyName, "Unknown"));
        System.out.println("\nMaximum Integer: " + GenericUtility.max(25, 50));
        System.out.println("Maximum String: " + GenericUtility.max("Apple", "Mango"));
        System.out.println("Maximum Double: " + GenericUtility.max(15.5, 12.5));

        String str = null;
        String text = "Hello";

        System.out.println("\nIs str null? " + GenericUtility.isNull(str));
        System.out.println("Is text null? " + GenericUtility.isNull(text));
    }
}