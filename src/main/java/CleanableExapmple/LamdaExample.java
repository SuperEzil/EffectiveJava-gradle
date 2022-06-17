package CleanableExapmple;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import java.io.FileDescriptor;
import java.lang.reflect.Field;

@Log4j2
public class LamdaExample {
private int value = 10;

private Runnable instanceLamda = () -> {
    /**
     * value를 참조 함으로써 캡처링이 발생하여 참조를 갖고 이에 따라 무한 참조에 빠진다.
     */
    log.info(value);
};


    public static void main(String[] args) {

        LamdaExample example = new LamdaExample();
       Field[] declaredFields = example.instanceLamda.getClass().getDeclaredFields();

        for (Field field:declaredFields) {
            log.debug("Field name: "+field.getName());
            log.info("Field type: "+field.getType());
        }


    }


}
