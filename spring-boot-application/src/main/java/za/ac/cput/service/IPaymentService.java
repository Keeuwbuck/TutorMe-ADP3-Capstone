package za.ac.cput.service;

import za.ac.cput.domain.Payment;

import java.util.List;

public interface IPaymentService {
    Payment create(Payment payment);

    Payment read(String paymentID);

    Payment update(Payment payment);

    boolean delete(String paymentID);

    List<Payment> getAll();
}
