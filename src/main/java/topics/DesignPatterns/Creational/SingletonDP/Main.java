package topics.DesignPatterns.Creational.SingletonDP;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(TVSet::getTvSetInstance);
        executorService.execute(TVSet::getTvSetInstance);
    }
}
