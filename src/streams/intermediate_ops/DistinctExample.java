package streams.intermediate_ops;

import streams.model.Order;

import java.util.List;

public class DistinctExample {
    static void main() {
        //remove duplicates
        List<String> distinctCityList = Order.orders.stream()
                .map(Order::getCity)
                .distinct()
                .toList();

        System.out.println(distinctCityList);

    }
}
