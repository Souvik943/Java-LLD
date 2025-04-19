package topics.DesignPatterns.Creational.FactoryDP.WithDP;

public class EmailNotification implements Notification {
    @Override
    public void notifyService() {
        System.out.println("Email Notification ...");
    }
}
