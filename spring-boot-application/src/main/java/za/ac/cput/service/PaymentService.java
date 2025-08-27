package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;
import java.util.List;
/* PaymentService.java
      payment service class
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */

public class PaymentService implements IPaymentService {

    private static IPaymentService service;
    private PaymentRepository repository;

    //@Override
    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    //@Override
    public Payment read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    //@Override
    public Payment update(Payment payment) {
        return this.repository.save(payment);
    }

    //@Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return true;
    }

    //@Override
    public List<Payment> getAll() {
        return this.repository.findAll();
    }
}