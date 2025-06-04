package topics.MultiThreading.Generic;

public class DemoThread {

    public static void main(String[] args) {
        ThreadExample thread = new ThreadExample();
        thread.setDaemon(true);
        thread.run();
        thread.start();
    }

}

class ThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("Am I a daemon thread ?" + Thread.currentThread().isDaemon());
        System.out.println("I am getting executed by :" + Thread.currentThread().getName());
    }
}
