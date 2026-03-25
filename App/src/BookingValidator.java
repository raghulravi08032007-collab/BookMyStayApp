import java.util.Map;

public class BookingValidator {

    public void validate(Reservation reservation, RoomInventory inventory)
            throws InvalidBookingException {

        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // ❌ Check invalid room type
        if (!availability.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid Room Type: " + roomType);
        }

        // ❌ Check null or empty guest name
        if (reservation.getGuestName() == null || reservation.getGuestName().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty");
        }

        // ❌ Check availability
        if (availability.get(roomType) <= 0) {
            throw new InvalidBookingException("No rooms available for type: " + roomType);
        }
    }
}