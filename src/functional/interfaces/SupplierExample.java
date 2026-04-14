package functional.interfaces;

import functional.model.Order;
import functional.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public class SupplierExample {
    private static final OrderRepository orderRepository = new OrderRepository();

    static void main() {
        //------------basic--------------

        //Lazy DB fetch - only executes when .get() is called
        Supplier<List<Order>> pendingOrderSupplier = ()-> orderRepository.findByStatus("PENDING");
        List<Order> fetchedOrders = pendingOrderSupplier.get();

        //Factory - create a default order
        Supplier<Order> defaultOrderSupplier = ()-> new Order(
                UUID.randomUUID().toString(),
                "GUEST",
                0.0,
                "Pune",
                null,
                "PENDING",
                LocalDateTime.now()
        );

        //--------------real world use----------------
        Order order = (Order) Optional.ofNullable(orderRepository.findById("7q28gbafhisdb892"))
                .orElseGet(defaultOrderSupplier);

    }
}
