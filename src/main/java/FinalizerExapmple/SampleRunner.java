package FinalizerExapmple;

public class SampleRunner {

    public static void main(String[] args) throws InterruptedException {
        SampleRunner runner = new SampleRunner();
        runner.run();
        //System.gc();
        Thread.sleep(1000L);
    }


    private void run(){
        FinalizerExapmple finalizerExapmple =  new FinalizerExapmple();
        finalizerExapmple.hello();
    }
}
