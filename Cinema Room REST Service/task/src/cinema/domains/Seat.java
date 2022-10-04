package cinema.domains;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Seat {
    @NonNull
    private int row;
    @NonNull
    private int column;
    private int price;
    @Setter
    private boolean isAvailable;
}
