package food.utility;

import food.model.FoodOrder;

public class OrderUtility {
    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String customerName) {
        return customerName != null && !customerName.trim().isEmpty();
    }

    public static void generateOrderSummary(FoodOrder order) {
        double discount = order.applyDiscount();
        double deliveryCharge = order.calculateDeliveryCharge();
        double finalAmount = order.getAmount() - discount + deliveryCharge;

        System.out.println("--- Bill for Order " + order.getOrderId() + " ---");
        System.out.println("Customer        : " + order.getCustomerName());
        System.out.println("Bill Amount     : Rs. " + order.getAmount());
        System.out.println("Discount        : Rs. " + discount);
        System.out.println("Delivery Charge : Rs. " + deliveryCharge);
        System.out.println("Final Payable   : Rs. " + finalAmount);
        System.out.println();
    }
}
