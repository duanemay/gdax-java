package com.coinbase.exchange.api.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by robevansuk on 20/02/2017.
 */
@Component
public class AuthorisationInterceptor extends HandlerInterceptorAdapter {

    String baseUrl;
    String key;
    String secret;
    String passphrase;

    @Autowired
    public AuthorisationInterceptor(@Value("${gdax.api.baseUrl}") String baseUrl,
                                    @Value("${gdax.key}") String key,
                                    @Value("${gdax.secret}") String secret,
                                    @Value("${gdax.passphrase}") String passphrase) {

        this.baseUrl = baseUrl;
        this.key = key;
        this.secret = secret;
        this.passphrase = passphrase;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        // Wrap the authorisation piece here so that we don't have to confuse the gdaxExchange
        // functionality with signing requests.
        return true;
    }
}
