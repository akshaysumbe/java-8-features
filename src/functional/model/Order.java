package functional.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private double amount;
    private String status;      // PENDING, CONFIRMED, SHIPPED, DELIVERED
    private String couponCode;
    private LocalDateTime createdAt;

    public Order() {
    }

    public Order(String id, String customerId, double amount, String status, String couponCode, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
        this.couponCode = couponCode;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", couponCode='" + couponCode + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public static List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("101", "c101", 101, "PENDING", "OFF_10", LocalDateTime.now()));
        orders.add(new Order("102", "c102", 102, "CONFIRMED", null, LocalDateTime.now()));
        orders.add(new Order("103", "c103", 103, "SHIPPED", null, LocalDateTime.now()));
        orders.add(new Order("104", "c104", 104, "DELIVERED", "OFF_5", LocalDateTime.now()));
        orders.add(new Order("105", "c105", 105, "CONFIRMED", null, LocalDateTime.now()));
        orders.add(new Order("106", null, 105, "PENDING", null, LocalDateTime.now()));
        orders.add(new Order("107", "c107", 0, "PENDING", "OFF_5", LocalDateTime.now()));

        return orders;
    }
}
