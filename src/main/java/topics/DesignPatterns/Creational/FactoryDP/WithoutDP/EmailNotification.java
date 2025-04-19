package topics.DesignPatterns.Creational.FactoryDP.WithoutDP;

public class EmailNotification implements Notification{

    @Override
    public void notifyService() {
        System.out.println("Email Notification Service");
    }
}
