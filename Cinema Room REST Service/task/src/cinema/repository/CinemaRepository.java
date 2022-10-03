package cinema.repository;

import cinema.domains.Seat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaRepository {
    private static final int ROWS_NUMBER = 9;
    private static final int COLUMN_NUMBER = 9;
    private static final List<Seat> SEATS;

    static  {
        SEATS = new ArrayList<>();
        for (int row = 1; row <= ROWS_NUMBER; row++) {
            for (int column = 1; column <= COLUMN_NUMBER; column++) {
                Seat seat = new Seat(row, column);
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
}
