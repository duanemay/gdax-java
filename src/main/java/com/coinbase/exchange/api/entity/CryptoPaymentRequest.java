package com.coinbase.exchange.api.entity;

import java.math.BigDecimal;

/**
 * Created by robevansuk on 15/02/2017.
 */
public class CryptoPaymentRequest
{

    String currency;
    BigDecimal amount;
    String crypto_address;

    public CryptoPaymentRequest(BigDecimal amount, String currency, String crypto_address) {
        this.currency = currency;
        this.amount = amount;
        this.crypto_address = crypto_address;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCrypto_address() {
        return crypto_address;
    }

    public void setCrypto_address(String crypto_address) {
        this.crypto_address = crypto_address;
    }
}
