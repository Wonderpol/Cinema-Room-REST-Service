package cinema.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CinemaRoom {
    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;
}
