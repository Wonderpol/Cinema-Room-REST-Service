package cinema.service;

import cinema.domains.CinemaRoom;
import cinema.domains.Seat;
import cinema.domains.dto.SeatDTO;
import cinema.repository.CinemaRepository;
import cinema.utils.exceptions.TicketAlreadyPurchasedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cinema.utils.Mapper;


@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final Mapper mapper;

    @Autowired
    public CinemaService(final CinemaRepository cinemaRepository, final Mapper mapper) {
        this.cinemaRepository = cinemaRepository;
        this.mapper = mapper;
    }

    public CinemaRoom getCinemaRoomInfo() {
        return new CinemaRoom(
                cinemaRepository.getRowsNumber(),
                cinemaRepository.getColumnNumber(),
                cinemaRepository.getSeats()
        );
    }

    public SeatDTO purchaseSeat(SeatDTO seat) throws TicketAlreadyPurchasedException {

        return cinemaRepository.getSeats()
                .stream()
                .filter(s -> s.getRow() == seat.getRow()
                        && s.getColumn() == seat.getColumn()
                        && s.isAvailable())
                .findAny()
                .map(mapper::toDto)
                .orElseThrow(TicketAlreadyPurchasedException::new);
    }

}
