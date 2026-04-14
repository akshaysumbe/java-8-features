package functional.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Invoice {
    private String invoiceId;
    private String orderId;
    private String customerId;
    private double amount;          // amount before GST
    private double gstAmount;       // 18% GST
    private double totalAmount;     // amount + GST
    private String status;          // GENERATED, PAID, CANCELLED
    private LocalDateTime createdAt;

    public Invoice(String orderId, String customerId, double totalAmount) {
        this.invoiceId   = "INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.orderId     = orderId;
        this.customerId  = customerId;
        this.totalAmount = totalAmount;
        this.amount      = totalAmount / 1.18;           // reverse-calculate base
        this.gstAmount   = totalAmount - this.amount;    // GST portion
        this.status      = "GENERATED";
        this.createdAt   = LocalDateTime.now();
    }

    public Invoice(String invoiceId, String orderId, String customerId,
                   double amount, double gstAmount, double totalAmount,
                   String status, LocalDateTime createdAt) {
        this.invoiceId   = invoiceId;
        this.orderId     = orderId;
        this.customerId  = customerId;
        this.amount      = amount;
        this.gstAmount   = gstAmount;
        this.totalAmount = totalAmount;
        this.status      = status;
        this.createdAt   = createdAt;
    }

    public String getInvoiceId()      { return invoiceId; }
    public String getOrderId()        { return orderId; }
    public String getCustomerId()     { return customerId; }
    public double getAmount()         { return amount; }
    public double getGstAmount()      { return gstAmount; }
    public double getTotalAmount()    { return totalAmount; }
    public String getStatus()         { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setStatus(String status)  { this.status = status; }

    @Override
    public String toString() {
        return String.format(
                "Invoice{id='%s', orderId='%s', customerId='%s', " +
                        "base=₹%.2f, gst=₹%.2f, total=₹%.2f, status='%s', createdAt=%s}",
                invoiceId, orderId, customerId,
                amount, gstAmount, totalAmount,
                status, createdAt
        );
    }
}
