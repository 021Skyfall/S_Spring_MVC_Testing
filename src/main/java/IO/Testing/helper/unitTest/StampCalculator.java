package IO.Testing.helper.unitTest;

import IO.Testing.order.entity.Order;

public class StampCalculator {
    public static int calculateStampCount(int currentCount, int earnedCount) {
        return currentCount + earnedCount;
    }

    public static int calculateEarnedStampCount(Order order) {
        return order.getOrderCoffees().stream()
                .map(orderCoffee -> orderCoffee.getQuantity())
                .mapToInt(e -> e)
                .sum();
    }
}
