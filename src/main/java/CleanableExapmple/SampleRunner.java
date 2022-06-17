package CleanableExapmple;

import java.util.ArrayList;
import java.util.List;

public class SampleRunner {

    public static void main(String[] args) throws InterruptedException {

        List<Object> resoruces = new ArrayList<>();
        CleanableResource cleanableResource = new CleanableResource(resoruces);

        cleanableResource = null;
        System.gc();
        Thread.sleep(3000l);
    }

}
