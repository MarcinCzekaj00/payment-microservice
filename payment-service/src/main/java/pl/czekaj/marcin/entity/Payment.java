package pl.czekaj.marcin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    private String paymentId;
    private String paymentStatus;
    private String transactionId;
    private String orderId;
    private double amount;
}
