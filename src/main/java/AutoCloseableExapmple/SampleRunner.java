package AutoCloseableExapmple;

public class SampleRunner {

    public static void main(String[] args) {
    try(AutoCloseableResource autoCloseableResource = new AutoCloseableResource()) {
        autoCloseableResource.hello();
    }
    }

}
