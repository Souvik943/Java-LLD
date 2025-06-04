package topics.MultiThreading.CreateThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {

        // Single Thread Executor
        ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor();
        System.out.println("Single Thread Executor");
        for(int i=0; i<3; i++) {
            singleThreadExecutorService.execute(() -> {
                System.out.println("Executing :" + Thread.currentThread().getName());
            });
        }
        singleThreadExecutorService.shutdown();

        // Fixed Thread Pool
        ExecutorService fixedThreadPoolExecutorService = Executors.newFixedThreadPool(10);
        System.out.println("Fixed Thread Pool");
        for(int i=0; i<20; i++) {
            fixedThreadPoolExecutorService.execute(() -> {
                System.out.println("Executing :" + Thread.currentThread().getName());
            });
        }

        singleThreadExecutorService.shutdown();
    }
}
