package topics.LLD.ParkingLot.model.payment;

public class Payment {
    protected String ticketId;
    protected double amount;
    protected PaymentStatus paymentStatus;

    public Payment(String ticketId, double amount, PaymentStatus paymentStatus) {
        this.ticketId = ticketId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public String getTicketId() {
        return ticketId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
