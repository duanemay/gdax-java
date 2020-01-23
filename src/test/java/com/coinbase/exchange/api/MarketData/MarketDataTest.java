package com.coinbase.exchange.api.MarketData;

import com.coinbase.exchange.api.BaseTest;
import com.coinbase.exchange.api.marketdata.MarketData;
import com.coinbase.exchange.api.marketdata.MarketDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by robevansuk on 14/02/2017.
 */
public class MarketDataTest extends BaseTest {

    @Autowired
    MarketDataService marketDataService;

    @Test
    public void canGetMarketDataForLevelOneBidAndAsk() {
        MarketData marketData = marketDataService.getMarketDataOrderBook("BTC-GBP", "1");
        System.out.println(marketData);
        assertThat(marketData.getSequence() > 0).isTrue();
    }

    @Test
    public void canGetMarketDataForLevelTwoBidAndAsk() {
        MarketData marketData = marketDataService.getMarketDataOrderBook("BTC-GBP", "2");
        System.out.println(marketData);
        assertThat(marketData.getSequence() > 0).isTrue();
    }

    /**
     * note that the returned results are slightly different for level 3. For level 3 you will see an
     * order Id rather than the count of orders at a certain price.
     */
    @Test
    public void canGetMarketDataForLevelThreeBidAndAsk() {
        MarketData marketData = marketDataService.getMarketDataOrderBook("BTC-GBP", "3");
        System.out.println(marketData);
        assertThat(marketData.getSequence() > 0).isTrue();
    }
}
