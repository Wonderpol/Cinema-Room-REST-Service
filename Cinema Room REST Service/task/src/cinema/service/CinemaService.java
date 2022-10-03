package cinema.service;

import cinema.domains.CinemaRoom;
import cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(final CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public CinemaRoom getCinemaRoomInfo() {
        return new CinemaRoom(
                cinemaRepository.getRowsNumber(),
                cinemaRepository.getColumnNumber(),
                cinemaRepository.getSeats()
        );
    }

}
