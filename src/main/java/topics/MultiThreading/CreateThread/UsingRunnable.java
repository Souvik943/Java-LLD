package topics.MultiThreading.CreateThread;

public class UsingRunnable {
    public static void main(String[] args) {
        Runnable runnableObj = () -> {
            System.out.println("Created threads using runnable . . .");
        };

        Thread thread = new Thread(runnableObj);
        thread.start();
    }
}
