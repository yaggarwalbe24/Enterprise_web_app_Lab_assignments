import java.util.Optional;
import java.util.Objects;

class Result<T extends Number> {
    private T[] marks;
    private double threshold;

    public Result(T[] marks, double threshold) {
        this.marks = Objects.requireNonNull(marks, "Marks cannot be null");
        Objects.requireNonNull(marks.length > 0 ? marks : null, "Marks array cannot be empty");
        this.threshold = threshold;
    }

    public double calculateAverage() {
        double sum = 0.0;
        for (T mark : marks) {
            sum += Objects.requireNonNull(mark, "Mark cannot be null").doubleValue();
        }
        return sum / marks.length;
    }

    public boolean hasPassed() {
        return calculateAverage() >= threshold;
    }

    public void displayResult() {
        Optional<Double> average = Optional.of(calculateAverage());
        average.ifPresent(avg -> {
            System.out.println("Average Marks: " + avg);
            System.out.println("Result: " + (hasPassed() ? "PASS" : "FAIL"));
        });
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] marks = {85, 90, 75, 80, 70};
        Result<Integer> student = new Result<>(marks, 40);
        student.displayResult();
    }
}