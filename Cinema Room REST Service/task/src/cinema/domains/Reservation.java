package cinema.domains;

import cinema.domains.dto.SeatDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    private UUID token;
    private SeatDTO seat;
}
