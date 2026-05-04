package optional.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private double amount;
    private String city;
    private String status;      // PENDING, CONFIRMED, SHIPPED, DELIVERED
    private String couponCode;
    private LocalDateTime createdAt;
    private String restaurantId;

    public Order(String id, String customerId, double amount, String city, String status, String couponCode, LocalDateTime createdAt, String restaurantId) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.city = city;
        this.status = status;
        this.couponCode = couponCode;
        this.createdAt = createdAt;
        this.restaurantId = restaurantId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", amount=" + amount +
                ", city='" + city + '\'' +
                ", status='" + status + '\'' +
                ", couponCode='" + couponCode + '\'' +
                ", createdAt=" + createdAt +
                ", restaurantId='" + restaurantId + '\'' +
                '}';
    }

    public static List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("101", "c101", 101, "Pune", "PENDING", "OFF_10", LocalDateTime.now(), "01"));
        orders.add(new Order("102", "c102", 102,"Bengaluru", "CONFIRMED", null, LocalDateTime.now(), "01"));
        orders.add(new Order("103", "c103", 103,"Pune", "SHIPPED", null, LocalDateTime.now(), "01"));
        orders.add(new Order("104", "c104", 104,"Sambhaji Nagar", "DELIVERED", "OFF_5", LocalDateTime.now(), "01"));
        orders.add(new Order("105", "c105", 105,"Gurugram", "CONFIRMED", null, LocalDateTime.now(), "01"));
        orders.add(new Order("106", null, 105,"Nagpur", "PENDING", null, LocalDateTime.now(), "01"));
        orders.add(new Order("107", "c107", 0, "Pune", "PENDING", "OFF_5", LocalDateTime.now(), "01"));

        return orders;
    }
}
