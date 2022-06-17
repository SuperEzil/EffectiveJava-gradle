package FinalizerExapmple;

import java.math.BigDecimal;

public class BrokenAccount extends Account{
    public BrokenAccount(String accountId) {
        super(accountId);
    }


    @Override
    protected void finalize() throws Throwable {
        //super.finalize();
        this.transfor(BigDecimal.valueOf(10101010), "푸틴");
        
    }
}
