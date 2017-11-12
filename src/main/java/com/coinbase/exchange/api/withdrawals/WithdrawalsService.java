package com.coinbase.exchange.api.withdrawals;

import com.coinbase.exchange.api.entity.CoinbasePaymentRequest;
import com.coinbase.exchange.api.entity.CryptoPaymentRequest;
import com.coinbase.exchange.api.exchange.GdaxExchange;
import com.coinbase.exchange.api.entity.PaymentRequest;
import com.coinbase.exchange.api.entity.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by robevansuk on 16/02/2017.
 */
@Component
public class WithdrawalsService {

    static final String WITHDRAWALS_ENDPOINT = "/withdrawals";
    static final String PAYMENT_METHOD = "/payment-method";
    static final String COINBASE = "/coinbase-account";
    static final String CRYPTO = "/crypto";


    @Autowired
    GdaxExchange gdaxExchange;

    // TODO untested - needs a payment method id.
    public PaymentResponse makeWithdrawalToPaymentMethod(BigDecimal amount, String currency, String paymentMethodId) {
        PaymentRequest withdrawalRequest = new PaymentRequest(amount, currency, paymentMethodId);
        return gdaxExchange.post(WITHDRAWALS_ENDPOINT+ PAYMENT_METHOD,
                new ParameterizedTypeReference<PaymentResponse>() {},
                withdrawalRequest);
    }

    public PaymentResponse makeWithdrawalToCoinbase(BigDecimal amount, String currency, String coinbaseAccountId) {
        CoinbasePaymentRequest withdrawalRequest = new CoinbasePaymentRequest(amount, currency, coinbaseAccountId);
        return gdaxExchange.post(WITHDRAWALS_ENDPOINT+ COINBASE,
                new ParameterizedTypeReference<PaymentResponse>() {},
                withdrawalRequest);
    }

    // TODO untested - needs a crypto currency account address
    public PaymentResponse makeWithdrawalToCryptoAccount(BigDecimal amount, String currency, String cryptoAddress) {
        CryptoPaymentRequest withdrawalRequest = new CryptoPaymentRequest(amount, currency, cryptoAddress);
        return gdaxExchange.post(WITHDRAWALS_ENDPOINT+ CRYPTO,
                new ParameterizedTypeReference<PaymentResponse>() {},
                withdrawalRequest);
    }
}
