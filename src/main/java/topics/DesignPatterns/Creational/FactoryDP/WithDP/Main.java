package topics.DesignPatterns.Creational.FactoryDP.WithDP;

public class Main {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        notificationFactory.notifyFactoryService("sms");

        NotificationFactory notificationFactory2 = new NotificationFactory();
        notificationFactory2.notifyFactoryService("email");

        // This will throw an exception
//        NotificationFactory notificationFactory3 = new NotificationFactory();
//        notificationFactory3.notifyFactoryService("push Notification");
    }
}
