package IO.Testing.helper.unitTest;

import IO.Testing.order.entity.Order;
import IO.Testing.order.entity.OrderCoffee;

import java.util.List;

public class StampCalculatorTestWithOutJunit {
    public static void main(String[] args) {
        calculateStampCountTest();
        calculateEarnedStampCountTest();
    }

    private static void calculateStampCountTest() {
        int currentCount = 5;
        int earnedCount = 3;

        int actual = StampCalculator.calculateStampCount(currentCount,earnedCount);

        int expected = 7;

        System.out.println(expected == actual);
    }

    private static void calculateEarnedStampCountTest() {
        // given
        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(3);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(5);

        order.setOrderCoffees(List.of(orderCoffee1,orderCoffee2));

        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();

        // when
        int actual = StampCalculator.calculateEarnedStampCount(order);

        // then
        System.out.println(expected == actual);
    }
}
