package FinalizerExapmple;

public class FinalizerExapmple {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() -  Clean up");
    }

    public void hello() {
        System.out.println("Hello");
    }
}
