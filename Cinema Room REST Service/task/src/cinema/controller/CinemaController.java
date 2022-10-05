package cinema.controller;

import cinema.domains.Reservation;
import cinema.domains.Seat;
import cinema.domains.Statistics;
import cinema.domains.Token;
import cinema.domains.dto.CinemaRoomDTO;
import cinema.domains.dto.SeatDTO;
import cinema.exceptions.InvalidPasswordException;
import cinema.exceptions.WrongTokenException;
import cinema.service.CinemaService;
import cinema.service.StatisticsService;
import cinema.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CinemaController {

    private final CinemaService cinemaService;
    private final StatisticsService statisticsService;
    private final Mapper mapper;

    @Autowired
    public CinemaController(final CinemaService cinemaService, final StatisticsService statisticsService, final Mapper mapper) {
        this.cinemaService = cinemaService;
        this.statisticsService = statisticsService;
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

    @PostMapping("/return")
    public ResponseEntity<Map<String, SeatDTO>> returnTicket(@RequestBody Token token) throws WrongTokenException {
        return new ResponseEntity<>(cinemaService.returnTicket(token), HttpStatus.OK);
    }

    @PostMapping("/stats")
    public ResponseEntity<Statistics> getStats(@RequestParam(required = false) String password) throws InvalidPasswordException {
        return new ResponseEntity<>(statisticsService.getStatistics(password), HttpStatus.OK);
    }

}
