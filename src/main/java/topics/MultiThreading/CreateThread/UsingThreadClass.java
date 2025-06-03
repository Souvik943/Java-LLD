package topics.MultiThreading.CreateThread;

// Legacy way of creating threads
public class UsingThreadClass extends Thread{

    @Override
    public void run() {
        System.out.println("Thread is created using Thread Class . . .");
    }

    public static void main(String[] args) {
        Thread legacyThread = new UsingThreadClass();
        System.out.println(legacyThread.getName());
        legacyThread.start();

        // This marks the use of lambda expressions
        Thread thread = new Thread(() -> {
            System.out.println("Thread is created using Thread class and lambda expression . . .");
        }, "Non-Legacy Thread");
        System.out.println(legacyThread.getName());
        thread.start();
    }
}
