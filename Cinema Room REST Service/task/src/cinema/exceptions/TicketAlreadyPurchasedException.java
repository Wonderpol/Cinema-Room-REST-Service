package cinema.exceptions;

public class TicketAlreadyPurchasedException extends Exception {

    public TicketAlreadyPurchasedException() {
        super();
    }

    public TicketAlreadyPurchasedException(final String message) {
        super(message);
    }
}
