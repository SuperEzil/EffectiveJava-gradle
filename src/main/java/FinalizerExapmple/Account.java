package FinalizerExapmple;

import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
@Log4j2
public class Account {
    private String accountId;

    public Account(String accountId) {
        this.accountId = accountId;

        if (accountId.equals("명박"))
            throw new IllegalArgumentException("명박이 계정을 막습니다.");
    }

    public void transfor(BigDecimal amount, String to) {
        log.info(String.format("transfor %f from %s to %s", amount, accountId, to));
    }
}
