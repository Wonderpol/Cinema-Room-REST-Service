package cinema.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CinemaRoomDTO {
    private int totalRows;
    private int totalColumns;
    private List<SeatDTO> availableSeats;
}
