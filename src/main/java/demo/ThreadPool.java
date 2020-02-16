package demo;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public enum  ThreadPool {
    INSTANCE;

    private final ScheduledExecutorService executorService;

    private ThreadPool() {
        executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    }
    public ScheduledExecutorService getInstance() {
        return executorService;
    }


}
