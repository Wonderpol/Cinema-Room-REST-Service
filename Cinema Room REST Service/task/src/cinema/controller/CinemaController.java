package cinema.controller;

import cinema.domains.dto.CinemaRoomDTO;
import cinema.service.CinemaService;
import cinema.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
