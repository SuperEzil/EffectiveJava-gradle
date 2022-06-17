package CleanableExapmple;


import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Field;

/**
 * 중첩 레퍼런스 참조 이슈
 * 중첩 클래스의 경우 Inner 클래스에서 바깥 참조를 하지 않아도 바로 레퍼런스를 참자를 한다.
 */
@Log4j2
public class OuterClass {

    private void hello(){
        log.info("hello");
    }

    /**
     * 중첩 클래스
     */
    class InnerClass{
        public void hello(){
            log.info("hello");
            OuterClass.this.hello();
        }

    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();

        log.info(outerClass);
        log.info(innerClass);

        outerClass.printFiled();
    }

    private void printFiled() {
        Field[] declaredFields = InnerClass.class.getDeclaredFields();

        for (Field field:declaredFields) {
            log.debug("Field name: "+field.getName());
            log.info("Field type: "+field.getType());

        }


    }

}
