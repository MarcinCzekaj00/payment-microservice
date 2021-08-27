package pl.czekaj.marcin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.czekaj.marcin.entity.Payment;

public interface PaymentRepository extends MongoRepository<Payment,String> {
    Payment findByOrderId(String orderId);
}
