package topics.DesignPatterns.Creational.FactoryDP.WithDP;

public class SmsNotification implements Notification {
    @Override
    public void notifyService() {
        System.out.println("Sms Notification ...");
    }
}
