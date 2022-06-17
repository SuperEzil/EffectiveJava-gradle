package FinalizerExapmple;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class FinalizerAttackTest {

    @Test
    void 일반_계정(){
        Account account = new Account("대중");
        account.transfor(BigDecimal.valueOf(103.2), "바이든");
    }   

    @Test
    void 명박_계정(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account("명박"), "명박이는 계정 생성이 불가능해야 한다.");
    }

    @Test
    void 명박_계정_공격() throws InterruptedException {
        Account account = null;

        try {
            account = new BrokenAccount("명박");
        }catch(IllegalArgumentException ex){
            System.out.println("예외 발생: "+ ex);
        }

        System.gc();
        Thread.sleep(3000l);

    }
}