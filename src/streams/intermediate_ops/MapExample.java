package streams.intermediate_ops;

import functional.model.Invoice;
import streams.model.Order;

import java.util.List;

public class MapExample {
    static void main() {
        //purpose : transform each element

        //Extract a field(Order -> order id)
        List<String> orderIdList = Order.orders.stream()
                .map(Order::getId)
                .toList();

        System.out.println("orderIdList: " + orderIdList);

        //type transformation
        //Order -> Invoice

        List<Invoice> invoices = Order.orders.stream()
                .map(order -> new Invoice(order.getId(), order.getCustomerId(),  order.getAmount()))
                .toList();

        System.out.println(invoices);

        //chained maps
        //uppercase cities
        List<String> upperCaseCities = Order.orders.stream()
                .map(Order::getCity)
                .map(String::toUpperCase)
                .distinct()
                .toList();

        System.out.println(upperCaseCities);


    }
}
