package cinema.service;

import cinema.domains.Seat;
import cinema.domains.Statistics;
import cinema.exceptions.InvalidPasswordException;
import cinema.repository.CinemaRepository;
import cinema.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final CinemaRepository cinemaRepository;
    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(final CinemaRepository cinemaRepository, final StatisticsRepository statisticsRepository) {
        this.cinemaRepository = cinemaRepository;
        this.statisticsRepository = statisticsRepository;
    }

    public Statistics getStatistics(String password) throws InvalidPasswordException {
        if (!isPasswordValid(password)) {
            throw new InvalidPasswordException("The password is wrong!");
        }
        return new Statistics(
                statisticsRepository.getCurrentIncome(),
                statisticsRepository.getNumberOfAvailableSeats(),
                statisticsRepository.getNumberOfPurchasedTickets()
        );
    }


    private boolean isPasswordValid(String password) {
        return password != null && password.equals(statisticsRepository.getPassword());
    }

}
