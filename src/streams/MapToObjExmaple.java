package streams;

import streams.model.GSTBreakdown;
import streams.model.Order;

import java.util.List;
import java.util.stream.IntStream;

public class MapToObjExmaple {
    static void main() {
        //generate paginated order IDs
        List<String> orderIdList = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> String.format("ord-%04d", i))
                .toList();
        System.out.println(orderIdList);

        //calculate per order gst amounts and wrap back into object
        List<Order> orders = Order.orders;
        List<GSTBreakdown> gstBreakdowns = orders.stream()
                .mapToDouble(Order::getAmount)
                .map(amount -> amount * 0.18)
                .mapToObj(gst -> new GSTBreakdown(
                        gst,
                        gst * 0.5,//CGST
                        gst * 0.5//SGST
                )).toList();
        System.out.println(gstBreakdowns);

    }
}
