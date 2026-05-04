package optional;

import streams.model.Order;

import java.util.Optional;

public class OrWithOptional {
    static void main() {

        //demonstration of or()
        Optional<Order> optOrder = findInCache("01")
                .or(()-> findInDatabase("01"))
                .or(()-> findInArchive("01"));

    }

    //NOTE: methods returning null as they are just for demonstration
    private static Optional<Order> findInCache(String id) {
        return null;
    }
    private static Optional<Order> findInDatabase(String id) {
        return null;
    }
    private static Optional<Order> findInArchive(String id) {
        return null;
    }
}
