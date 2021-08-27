package pl.czekaj.marcin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.czekaj.marcin.common.Payment;
import pl.czekaj.marcin.common.TransactionRequest;
import pl.czekaj.marcin.common.TransactionResponse;
import pl.czekaj.marcin.entity.Order;
import pl.czekaj.marcin.repository.OrderRepository;

@Service
@RefreshScope
@PropertySource(value={"classpath:application.yml"})
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    public TransactionResponse saveOrder(TransactionRequest request){
        String response="";

        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        Payment paymentResponse = restTemplate.postForObject(ENDPOINT_URL,payment,Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"there is a failure in payment api,order added to cart";
        repository.save(order);

        return new TransactionResponse(order,paymentResponse.getAmount(), paymentResponse.getTransactionId(),response);
    }
}
