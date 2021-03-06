package pl.czekaj.marcin.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private String paymentId;
    private String paymentStatus;
    private String transactionId;
    private String orderId;
    private double amount;
}
