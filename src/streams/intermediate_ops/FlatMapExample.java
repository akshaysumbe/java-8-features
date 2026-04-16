package streams.intermediate_ops;

import streams.model.Order;
import streams.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class FlatMapExample {
    static void main() {

        //-------------prepare data for example-------------
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Pizza", 2, 1299.00));
        orderItems.add(new OrderItem("Samosa", 20, 400.00));
        orderItems.add(new OrderItem("Pani Puri", 1, 70.00));

        Order.orders.stream()
                .filter(order -> order.getStatus().equals("PENDING"))
                .forEach(order -> order.setItems(orderItems));
        //---------------------------------------------

        //-------------------use-----------------------
        List<OrderItem> items = Order.orders.stream()
                .filter(order -> order.getStatus().equals("PENDING"))
                .flatMap(order ->
                        order.getItems().stream())
                .toList();

        items.forEach(System.out::println);
    }
}
