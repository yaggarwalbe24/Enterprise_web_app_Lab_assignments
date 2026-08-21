package food.service;

import food.model.FoodOrder;
import food.utility.OrderUtility;

public class OrderService {
    private FoodOrder[] orders;

    public OrderService(FoodOrder[] orders) {
        this.orders = orders;
    }

    public void displayAllOrders() {
        for (FoodOrder order : orders) {
            OrderUtility.generateOrderSummary(order);
        }
    }
}
