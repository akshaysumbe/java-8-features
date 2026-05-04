package optional;

import optional.model.Order;
import optional.service.OrderService;

import java.util.List;
import java.util.Optional;

public class StreamWithOptional {

    private static OrderService orderService = new OrderService();

    //Optional -> Stream (0 or 1 element)
    //Empty optional -> empty stream
    //Present optional -> Stream with 1 element

    static void main() {
        List<String> customerIds = List.of("C1", "C2", "C3", "C4", "C5", "C6");

        List<Order> orderList = customerIds.stream()
                .map(id -> orderService.findLastOrder(id))//Stream<Optional<Optional<Order>>
                .flatMap(Optional::stream)//Stream<Order> - empties removed
                .toList();

        //OR

        List<Order> orderList2 = customerIds.stream()
                .flatMap(id -> orderService.findLastOrder(id).stream())
                .toList();

    }
}
