package cinema.repository;

import cinema.domains.Seat;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsRepository {
    private final String SECRET_PASSWORD = "super_secret";

    private final CinemaRepository cinemaRepository;

    public StatisticsRepository(final CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public int getCurrentIncome() {
        return cinemaRepository
                .getReservations()
                .stream()
                .mapToInt(value -> value.getTicket().getPrice())
                .sum();
    }

    public int getNumberOfAvailableSeats() {
        return cinemaRepository
                .getSeats()
                .stream()
                .filter(Seat::isAvailable)
                .toList()
                .size();
    }

    public int getNumberOfPurchasedTickets() {
        return cinemaRepository
                .getReservations()
                .size();
    }
    public String getPassword() {
        return SECRET_PASSWORD;
    }
}
