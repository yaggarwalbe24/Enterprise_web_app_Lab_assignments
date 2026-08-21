package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.service.OrderService;
import food.utility.OrderUtility;

public class Main {
  public static void main(String[] args) {
    FoodOrder[] orders = {
        new RegularOrder("F1001", "Aarav", 540.0),
        new PremiumOrder("F1002", "Bhavna", 1250.0),
        new RegularOrder("F1003", "Chirag", 320.0),
        new PremiumOrder("F1004", "Divya", 980.0),
        new RegularOrder("F1005", "Esha", 210.0),
        new PremiumOrder("F1006", "Farhan", 1500.0)
    };

    System.out.println("Restaurant : " + FoodOrder.getRestaurantName());
    System.out.println();

    int valid = 0;
    for (FoodOrder order : orders) {
      if (OrderUtility.validateAmount(order.getAmount())
          && OrderUtility.validateCustomerName(order.getCustomerName())) {
        valid++;
      } else {
        System.out.println("Invalid order skipped: " + order.getOrderId());
      }
    }
    System.out.println(valid + "/" + orders.length + " orders passed validation.");
    System.out.println();

    OrderService service = new OrderService(orders);
    service.displayAllOrders();

    FoodOrder.displayTotalOrders();
  }
}
