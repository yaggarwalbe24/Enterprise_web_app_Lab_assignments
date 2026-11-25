import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> email = Optional.of("student@gmail.com");
        Optional<String> emptyEmail = Optional.empty();
        System.out.println("Student Email:");
        email.ifPresent(e -> System.out.println(e));
        String defaultEmail = emptyEmail.orElse("default@gmail.com");
        System.out.println("\nEmail using orElse(): " + defaultEmail);
        try {
            String missingEmail = emptyEmail.orElseThrow(
                () -> new RuntimeException("Email address is missing!")
            );
            System.out.println("Email: " + missingEmail);
        }
        catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}