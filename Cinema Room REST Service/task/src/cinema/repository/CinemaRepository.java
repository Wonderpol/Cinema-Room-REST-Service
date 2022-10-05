package cinema.repository;

import cinema.domains.Reservation;
import cinema.domains.Seat;
import cinema.domains.Token;
import cinema.domains.dto.SeatDTO;
import cinema.exceptions.WrongTokenException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class CinemaRepository {
    private static final int ROWS_NUMBER = 9;
    private static final int COLUMN_NUMBER = 9;
    private static final List<Seat> SEATS;
    private static final List<Reservation> RESERVATIONS;

    static  {
        SEATS = new ArrayList<>();
        RESERVATIONS = new ArrayList<>();
        for (int row = 1; row <= ROWS_NUMBER; row++) {
            for (int column = 1; column <= COLUMN_NUMBER; column++) {
                Seat seat = new Seat(row, column, row <= 4 ? 10 : 8, true);
                SEATS.add(seat);
            }
        }
    }

    public int getRowsNumber() {
        return ROWS_NUMBER;
    }

    public int getColumnNumber() {
        return COLUMN_NUMBER;
    }

    public List<Seat> getSeats() {
        return SEATS;
    }

    public Reservation saveReservation(SeatDTO seat) {
        final Reservation reservation = new Reservation(new Token().toString(), seat);
        RESERVATIONS.add(reservation);
        return reservation;
    }

    public List<Reservation> getReservations() {
        return RESERVATIONS;
    }

    public Reservation deleteReservationByToken(Token token) throws IllegalArgumentException{
        final Reservation reservation = RESERVATIONS
                        .stream()
                        .filter(r -> r.getToken().equals(token.getToken().toString()))
                        .findAny()
                        .orElseThrow(IllegalArgumentException::new);

        RESERVATIONS.remove(reservation);

        return reservation;
    }
}
