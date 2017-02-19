package com.coinbase.exchange.api.websocket;

/**
 * If you send this to the websocket feed you'll get
 * heartbeat messages once every second from the feed.
 * Set type = 'heartbeat', on = true.
 * Created by robevansuk on 19/02/2017.
 */
public class HeartbeatMessage {
    String type;
    Boolean on;

    public HeartbeatMessage(String type, Boolean on) {
        this.type = type;
        this.on = on;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }
}
