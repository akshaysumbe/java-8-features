package functional.interfaces;

import functional.model.Invoice;
import functional.model.Order;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
    static void main() {
        //---------basic---------

        //Order -> Invoice (transform one type to another)
        Function<Order, Invoice> toInvoice = order -> new Invoice(
                order.getId(),
                order.getCustomerId(),
                order.getAmount() * 1.18 // add 18% GST
        );

        //Order -> String summary
        Function<Order, String> toSummary = order ->
                String.format("Order[%s] | Customer[%s] | INR%2f",
                        order.getId(), order.getCustomerId(), order.getAmount());

        //String -> Integer (parsing)
        Function<String, Integer> parseLength = String::length;

        //---------composite functions---------
        //andThen : Order -> Invoice -> String(for logging)
        Function<Invoice, String> invoiceToLog = invoice -> "Invoice generated: " + invoice.getInvoiceId();

        Function<Order, String> orderToLog = toInvoice.andThen(invoiceToLog);

        //compose - do the OTHER thing first, THEN this
        //compose is reverse of the andThen()

        Function<String, String> trim = String::trim;
        Function<String, String> toUpper = String::toUpperCase;

        Function<String, String> cleanInput = toUpper.compose(trim);//first trims, then uppercases
        System.out.println(cleanInput.apply("Akshay    "));

        //---------usage---------
        Order.getOrders().stream()
                .map(toInvoice)
                .map(invoiceToLog)
                .forEach(System.out::println);

        //---------Function.identity()---------
        //returns the input unchanged - useful in collectors/ maps
        Function<Order, Order> noOp = Function.identity();

        Map<String, Order> orderMap = Order.getOrders().stream()
                .collect(Collectors.toMap(Order::getId, Function.identity()));

        System.out.println(orderMap);
    }
}
