package cinema.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Seat {
    @NonNull
    private int row;
    @NonNull
    private int column;
    private int price;
    private boolean isAvailable;
}
