public class GenericArraySum {

    public static <T extends Number> double calculateSum(T[] arr) {
        double sum = 0.0;
        for (T num : arr) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {

        Integer[] intArray = {10, 20, 30, 40, 50};
        Float[] floatArray = {1.5f, 2.5f, 3.5f, 4.5f};
        Double[] doubleArray = {10.5, 20.5, 30.5, 40.5};
        System.out.println("Sum of Integer array: " + calculateSum(intArray));
        System.out.println("Sum of Float array: " + calculateSum(floatArray));
        System.out.println("Sum of Double array: " + calculateSum(doubleArray));
    }
}