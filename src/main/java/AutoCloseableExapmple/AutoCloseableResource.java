package AutoCloseableExapmple;

import lombok.extern.log4j.Log4j2;

import java.lang.ref.Cleaner;

@Log4j2
public class AutoCloseableResource implements AutoCloseable {
    private boolean closed;
    private final Cleaner.Cleanable cleanable;
    private final ResourceCleaner resourceCleaner;

    public AutoCloseableResource() {
        this.resourceCleaner = new ResourceCleaner();
        this.cleanable = Cleaner.create().register(this, resourceCleaner);
    }
    @Log4j2
    private static class ResourceCleaner implements Runnable {

        @Override
        public void run() {
            log.info("run() - close");
        }
    }

    @Override
    public void close() throws RuntimeException {
       log.info("close()");

        if (this.closed)
            throw new IllegalStateException();

        cleanable.clean();
    }

    public void hello() {
        log.info("hello()");

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        log.info("finalize()");

        if (!this.closed)
            close();
    }
}
