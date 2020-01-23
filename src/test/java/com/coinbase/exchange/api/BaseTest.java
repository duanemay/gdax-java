package com.coinbase.exchange.api;

import com.coinbase.exchange.api.exchange.GdaxExchange;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by robevansuk on 20/01/2017.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
                 GdaxApiApplication.class
                },
                properties = {
                    "spring.profiles.active=test"
                }
)
public abstract class BaseTest {

    @Autowired
    public GdaxExchange exchange;
}