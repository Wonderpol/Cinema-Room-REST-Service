package cinema.exceptions.exceptionsHandler;

import cinema.domains.ErrorResponse;
import cinema.exceptions.SeatDoesNotExistException;
import cinema.exceptions.TicketAlreadyPurchasedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {SeatDoesNotExistException.class})
    public ResponseEntity<ErrorResponse> seatDoesNotExistExceptionHandler(Exception ex) {
        final ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {TicketAlreadyPurchasedException.class})
    public ResponseEntity<ErrorResponse> ticketAlreadyPurchasedException(Exception ex) {
        final ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> globalBaseExceptionHandler(Exception exception) {
        final ErrorResponse errorResponse = new ErrorResponse(
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
