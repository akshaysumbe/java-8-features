package optional;

import optional.model.Order;
import optional.model.Restaurant;
import optional.service.OrderService;
import optional.service.RestaurantService;

import java.util.Optional;

public class FlatMapWithOptional {
    private static RestaurantService restaurantService = new RestaurantService();
    private static OrderService orderService = new OrderService();

    static void main() {
        Optional<Order> optOrder = orderService.findLastOrder("01");

        //double wrapped
        Optional<Optional<Restaurant>> nested =
                optOrder.map(order -> restaurantService.findRestaurant(order.getRestaurantId()));

        //solution: flatMap
        Optional<Restaurant> restaurant =
                optOrder.flatMap(order -> restaurantService.findRestaurant(order.getRestaurantId()));
    }
}
