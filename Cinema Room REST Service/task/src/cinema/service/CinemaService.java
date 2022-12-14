package cinema.service;

import cinema.domains.CinemaRoom;
import cinema.domains.Reservation;
import cinema.domains.Seat;
import cinema.domains.Token;
import cinema.domains.dto.SeatDTO;
import cinema.exceptions.WrongTokenException;
import cinema.repository.CinemaRepository;
import cinema.exceptions.SeatDoesNotExistException;
import cinema.exceptions.TicketAlreadyPurchasedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cinema.utils.Mapper;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

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
                cinemaRepository.getSeats().stream().filter(Seat::isAvailable).collect(Collectors.toList())
        );
    }

    public Reservation purchaseSeat(Seat seat) throws TicketAlreadyPurchasedException, SeatDoesNotExistException {

        if (ifSeatDoesNotExists(seat)) {
            throw new SeatDoesNotExistException("The number of a row or a column is out of bounds!");
        }

        Seat bookedSeat =  cinemaRepository.getSeats()
                .stream()
                .filter(s -> s.getRow() == seat.getRow()
                        && s.getColumn() == seat.getColumn()
                        && s.isAvailable())

                .findAny()
                .orElseThrow(() -> new TicketAlreadyPurchasedException("The ticket has been already purchased!"));

        bookedSeat.setAvailable(false);

        return cinemaRepository.saveReservation(mapper.toDto(bookedSeat));
    }

    public Map<String, SeatDTO> returnTicket(Token token) throws WrongTokenException {
        Reservation reservation;
        try {
            reservation = cinemaRepository.deleteReservationByToken(token);
        } catch (IllegalArgumentException ex) {
            throw new WrongTokenException("Wrong token!");
        }
        return Map.of("returned_ticket", reservation.getTicket());
    }

    private boolean ifSeatDoesNotExists(Seat seat) {
        return cinemaRepository.getSeats()
                .stream()
                .filter(s -> s.getRow() == seat.getRow() && s.getColumn() == seat.getColumn())
                .findAny()
                .isEmpty();
    }
}

