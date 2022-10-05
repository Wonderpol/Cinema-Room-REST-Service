package cinema.exceptions.exceptionsHandler;

import cinema.domains.response.ErrorResponse;
import cinema.exceptions.InvalidPasswordException;
import cinema.exceptions.SeatDoesNotExistException;
import cinema.exceptions.TicketAlreadyPurchasedException;
import cinema.exceptions.WrongTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value =
            {
                    SeatDoesNotExistException.class,
                    TicketAlreadyPurchasedException.class,
                    WrongTokenException.class
            })
    public ResponseEntity<ErrorResponse> seatDoesNotExistExceptionHandler(Exception ex) {
        final ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidPasswordException.class})
    public ResponseEntity<ErrorResponse> invalidPasswordException(Exception ex) {
        final ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> globalBaseExceptionHandler(Exception exception) {
        final ErrorResponse errorResponse = new ErrorResponse(
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
