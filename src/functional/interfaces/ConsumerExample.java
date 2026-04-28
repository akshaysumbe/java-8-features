package functional.interfaces;

import functional.model.Order;
import functional.repository.OrderRepository;
import functional.service.UtilityService;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public class ConsumerExample {
    private static final UtilityService UTILITY_SERVICE = new UtilityService();
    private static final OrderRepository ORDER_REPOSITORY = new OrderRepository();

    static void main() {
        //-----------------basic-----------------

        //Send Order confirmation email
        Consumer<Order> sendEmail = order -> UTILITY_SERVICE.sendEmail(order.getCustomerId(),
                "Order confirmed, Order No : " + order.getId());

        //log order for audit trail
        Consumer<Order> auditLog = order -> UTILITY_SERVICE.log("ORDER_CREATED", order.getId(), LocalDateTime.now());

        //save order to DB

        Consumer<Order> saveToDb = ORDER_REPOSITORY::saveOrder;

        // chaining consumers with andThen
        // execute multiple side effects in sequence

        Consumer<Order> onOrderConfirmed = saveToDb.andThen(sendEmail)
                .andThen(auditLog);

        //-----------------usage-----------------
        Order.getOrders().forEach(onOrderConfirmed);

    }
}
