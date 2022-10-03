package cinema.utils;

import cinema.domains.CinemaRoom;
import cinema.domains.Seat;
import cinema.domains.dto.CinemaRoomDTO;
import cinema.domains.dto.SeatDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {
    public SeatDTO toDto(Seat seat) {
        return new SeatDTO(seat.getRow(), seat.getColumn(), seat.getPrice());
    }

    public CinemaRoomDTO toDto(CinemaRoom cinemaRoom) {
        List<SeatDTO> seats = cinemaRoom.getAvailableSeats()
                .stream()
                .map(this::toDto)
                .toList();

        return new CinemaRoomDTO(cinemaRoom.getTotalRows(), cinemaRoom.getTotalColumns(), seats);
    }

}
