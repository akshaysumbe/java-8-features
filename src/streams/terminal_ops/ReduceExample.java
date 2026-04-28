package streams.terminal_ops;

import streams.model.Order;

import java.util.Optional;

public class ReduceExample {
    static void main(String[] args) {

        //reduce - aggregate to single value

        //total revenue

        Double totalRevenue = Order.orders.stream()
                .map(Order::getAmount)
                .reduce(0.0, Double::sum);

        System.out.println("totalRevenue " + totalRevenue);

        //with identity and BinaryOperator explicitly
        Double total = Order.orders.stream()
                .map(Order::getAmount)
                .reduce(0.0, (sum, amount) -> sum + amount);

        System.out.println("Total amount : " +  total);

        //without identity - returns Optional(stream could be empty)
        Optional<Double> optionalMaxAmount = Order.orders.stream()
                .map(Order::getAmount)
                .reduce(Double::max);

        optionalMaxAmount.ifPresent(max-> System.out.println("max : " + max));


    }
}
