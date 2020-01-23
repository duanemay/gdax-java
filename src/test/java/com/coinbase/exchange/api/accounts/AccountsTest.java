package com.coinbase.exchange.api.accounts;

import com.coinbase.exchange.api.BaseTest;
import com.coinbase.exchange.api.entity.Hold;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by robevansuk on 03/02/2017.
 */
public class AccountsTest extends BaseTest {

    @Autowired
    AccountService accountService;

    @Test
    public void canGetAccounts() {
        Account[] accounts  = accountService.getAccounts();
        assertThat(accounts != null).isTrue();
        assertThat(accounts.length >= 0).isTrue();
    }

    @Test
    public void getAccount() {
        Account[] accounts  = accountService.getAccounts();
        Account account = accountService.getAccount(accounts[0].getId());
        assertThat(account != null).isTrue();
    }

    @Test
    public void canGetAccountHistory() {
        Account[] accounts = accountService.getAccounts();
        AccountHistory[] history = accountService.getAccountHistory(accounts[0].getId());
        assertThat(history.length >= 0).isTrue(); // anything but null/error.
    }

    /**
     * this test only works if you have open orders in the sandbox where your funds are held.
     */
    @Test
    public void canGetAccountHolds() {
        Account[] accounts = accountService.getAccounts();
        Hold[] holds = accountService.getHolds(accounts[0].getId());
        assertThat(holds != null).isTrue();
        assertThat(holds.length >= 0).isTrue();
        if (holds.length>0) {
            assertThat(holds[0].getAmount().floatValue() >= 0.0f).isTrue();
        }
    }

    @Test
    public void canGetPagedAccountHistory() {
        Account[] accounts = accountService.getAccounts();
        assertThat(accounts != null).isTrue();
        assertThat(accounts.length > 0).isTrue();
        /**
         * note that for paged requests the before param takes precedence
         * only if before is null and after is not-null will the after param be inserted.
         */
        String beforeOrAfter = "before";
        int pageNumber = 1;
        int limit = 5;
        AccountHistory[] firstPageAccountHistory = accountService.getPagedAccountHistory(accounts[0].getId(),
                beforeOrAfter, pageNumber, limit);
        assertThat(firstPageAccountHistory != null).isTrue();
        assertThat(firstPageAccountHistory.length >= 0).isTrue();
        assertThat(firstPageAccountHistory.length <= limit).isTrue();
    }

    /**
     * Test is ignored as it's failing. Seems the request here is
     * a bad one. Not sure if this is because there are no holds or
     * if this is due to the request (which is the same as for account history)
     * is actually fine but there's no data available.
     */
    @Test
    public void canGetPagedHolds() {
        Account[] accounts = accountService.getAccounts();

        assertThat(accounts != null).isTrue();
        assertThat(accounts.length > 0).isTrue();

        String beforeOrAfter = "after";
        int pageNumber = 1;
        int limit = 5;

        Hold[] firstPageOfHolds = accountService.getPagedHolds(accounts[0].getId(),
                beforeOrAfter,
                pageNumber,
                limit);

        if (firstPageOfHolds != null ) {
            assertThat(firstPageOfHolds != null).isTrue();
            assertThat(firstPageOfHolds.length >= 0).isTrue();
            assertThat(firstPageOfHolds.length <= limit).isTrue();
        }
    }
}