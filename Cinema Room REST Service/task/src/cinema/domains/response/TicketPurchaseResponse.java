package cinema.domains.response;

import cinema.domains.dto.SeatDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class TicketPurchaseResponse {
    @NonNull
    private UUID token;
    @NonNull
    private SeatDTO ticket;
}
