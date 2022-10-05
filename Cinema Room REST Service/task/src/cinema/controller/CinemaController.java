package cinema.controller;

import cinema.domains.Reservation;
import cinema.domains.Seat;
import cinema.domains.dto.CinemaRoomDTO;
import cinema.domains.dto.SeatDTO;
import cinema.service.CinemaService;
import cinema.utils.Mapper;
import cinema.exceptions.SeatDoesNotExistException;
import cinema.exceptions.TicketAlreadyPurchasedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CinemaController {

    private final CinemaService cinemaService;
    private final Mapper mapper;

    @Autowired
    public CinemaController(final CinemaService cinemaService, final Mapper mapper) {
        this.cinemaService = cinemaService;
        this.mapper = mapper;
    }

    @GetMapping("/seats")
    public CinemaRoomDTO getCinemaRoomInfo() {
       return mapper.toDto(cinemaService.getCinemaRoomInfo());
    }

    @PostMapping("/purchase")
    public ResponseEntity<Reservation> purchaseSeat(@RequestBody Seat seat) throws Exception {
        return new ResponseEntity<>(cinemaService.purchaseSeat(seat), HttpStatus.OK);
    }

}
