package com.coinbase.exchange.api.websocket;

/**
 * Created by robevansuk on 19/02/2017.
 */
public class SubscribeMessage {

    String type;
    String[] product_ids;
    String signature;
    String key;
    String passphrase;
    String timestamp;

    public SubscribeMessage(String type,
                            String[] product_ids,
                            String signature,
                            String key,
                            String passphrase,
                            String timestamp) {
        this.type = type;
        this.product_ids = product_ids;
        this.signature = signature;
        this.key = key;
        this.passphrase = passphrase;
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getProduct_ids() {
        return product_ids;
    }

    public void setProduct_ids(String[] product_ids) {
        this.product_ids = product_ids;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
