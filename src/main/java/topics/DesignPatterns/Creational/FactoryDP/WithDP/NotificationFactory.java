package topics.DesignPatterns.Creational.FactoryDP.WithDP;

public class NotificationFactory {
    public void notifyFactoryService(String option) {
        if(option.equals("sms")) {
            SmsNotification smsNotification = new SmsNotification();
            smsNotification.notifyService();
        }
        else if(option.equals("email")) {
            EmailNotification emailNotification = new EmailNotification();
            emailNotification.notifyService();
        }
        else {
            throw new RuntimeException("Specified option of notification isn't available .");
        }
    }
}
