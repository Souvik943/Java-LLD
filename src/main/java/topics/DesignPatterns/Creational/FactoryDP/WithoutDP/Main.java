package topics.DesignPatterns.Creational.FactoryDP.WithoutDP;

public class Main {
    public static void main(String[] args) {
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.notifyService();

        SmsNotification smsNotification = new SmsNotification();
        smsNotification.notifyService();
    }
}
