package CleanableExapmple;

import java.lang.ref.Cleaner;
import java.util.List;

public class CleanableResource {
    private List<Object> resource;

    public CleanableResource(List<Object> resource) {
        this.resource = resource;

        Cleaner cleaner = Cleaner.create();
        cleaner.register(this, new ResourceCleaner(resource));

    }

    public static class ResourceCleaner implements Runnable {

        private List<Object> resourceToClean;

        public ResourceCleaner(List<Object> resourceToClean) {
            this.resourceToClean = resourceToClean;
        }

        @Override
        public void run() {
            resourceToClean = null;
            System.out.println("ResourceCleaner run() - close");
        }
    }
}
