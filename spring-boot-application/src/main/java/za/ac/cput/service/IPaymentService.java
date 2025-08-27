package za.ac.cput.service;
import za.ac.cput.domain.Payment;
import java.util.List;

/* IPaymentService.java
      Payment service interface
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */

public interface IPaymentService {
    Payment create(Payment payment);
    Payment read(String id);
    Payment update(Payment payment);
    boolean delete(String id);
    List<Payment> getAll();
}
