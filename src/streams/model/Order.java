package streams.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private String restaurantId;
    private String city;
    private double amount;
    private int deliveryTimeMinutes;
    private String status;         // PENDING, CONFIRMED, DELIVERED, CANCELLED
    private LocalDateTime createdAt;
    private List<OrderItem> items;

    public Order() {
    }

    public Order(String id, String customerId, String restaurantId, String city, double amount, int deliveryTimeMinutes, String status, LocalDateTime createdAt, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.city = city;
        this.amount = amount;
        this.deliveryTimeMinutes = deliveryTimeMinutes;
        this.status = status;
        this.createdAt = createdAt;
        this.items = items;
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

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDeliveryTimeMinutes() {
        return deliveryTimeMinutes;
    }

    public void setDeliveryTimeMinutes(int deliveryTimeMinutes) {
        this.deliveryTimeMinutes = deliveryTimeMinutes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", city='" + city + '\'' +
                ", amount=" + amount +
                ", deliveryTimeMinutes=" + deliveryTimeMinutes +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", items=" + items +
                '}';
    }

    //sample data

    public static List<Order> orders = List.of(
            new Order("O1", "C1", "R1", "Pune",   850.0,  32, "DELIVERED", LocalDateTime.now(), null),
            new Order("O2", "C2", "R1", "Pune",  1200.0,  48, "DELIVERED", LocalDateTime.now(), null),
            new Order("O3", "C3", "R2", "Mumbai", 450.0,  28, "DELIVERED", LocalDateTime.now(), null),
            new Order("O4", "C4", "R2", "Pune",   300.0,  15, "CANCELLED", LocalDateTime.now(), null),
            new Order("O5", "C5", "R3", "Mumbai", 950.0,  55, "DELIVERED", LocalDateTime.now(), null),
            new Order("O6", "C6", "R3", "Pune",  2000.0,  40, "DELIVERED", LocalDateTime.now(), null),
            new Order("O7", "C7", "R1", "Pune",   750.0,  35, "PENDING", LocalDateTime.now(), null)
    );
}
