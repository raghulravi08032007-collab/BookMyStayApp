import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookingHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    public List<Reservation> getAllBookings() {
        return history;
    }
}