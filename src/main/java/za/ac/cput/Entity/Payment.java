package za.ac.cput.Entity;

/* Payment.java
      Review POJO class
     Author: Cameron Savage (230582567)
     Date: 11 May 2025
     */

import java.time.LocalDateTime;

public class Payment {
private String paymentID;
private double amount;
private LocalDateTime paymentDate;
private String paymentMethod;
private String status;
private String transactionID;
    public Payment() {
    }

    private Payment(PaymentBuilder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.paymentDate = builder.paymentDate;
        this.paymentMethod = builder.paymentMethod;
        this.status = builder.status;
        this.transactionID = builder.transactionID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                ", transactionID='" + transactionID + '\'' +
                '}';
    }

    public static class PaymentBuilder {
        private String paymentID;
        private double amount;
        private LocalDateTime paymentDate;
        private String paymentMethod;
        private String status;
        private String transactionID;

        public PaymentBuilder(String paymentID, double amount, LocalDateTime paymentDate,
                              String paymentMethod, String status, String transactionID) {
            this.paymentID = paymentID;
            this.amount = amount;
            this.paymentDate = paymentDate;
            this.paymentMethod = paymentMethod;
            this.status = status;
            this.transactionID = transactionID;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}