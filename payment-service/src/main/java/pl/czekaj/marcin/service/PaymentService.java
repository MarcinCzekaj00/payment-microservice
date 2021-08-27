package pl.czekaj.marcin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.czekaj.marcin.entity.Payment;
import pl.czekaj.marcin.repository.PaymentRepository;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }

    public Payment findPaymentHistoryByOrderId(String orderId){
        return repository.findByOrderId(orderId);
    }


    public String paymentProcessing(){
        return new Random().nextBoolean()?"success":"false";
    }
}
