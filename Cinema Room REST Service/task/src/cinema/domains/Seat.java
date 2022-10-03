package cinema.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Seat {
    private int row;
    private int column;
    private int price;
    private boolean isAvailable;
}
