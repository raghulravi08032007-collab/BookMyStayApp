import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoomAllocationService {

    private Map<String, Set<String>> allocatedRooms;

    public RoomAllocationService() {
        allocatedRooms = new HashMap<>();
    }

    public void processBookingRequests(
            BookingRequestQueue queue,
            RoomInventory inventory) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        while (queue.hasPendingRequests()) {

            Reservation request = queue.getNextRequest();
            String roomType = request.getRoomType();

            System.out.println("Processing request for: " + request.getGuestName());

            // Check availability
            if (availability.get(roomType) != null && availability.get(roomType) > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Store allocated room
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());
                allocatedRooms.get(roomType).add(roomId);

                // Update inventory
                availability.put(roomType, availability.get(roomType) - 1);

                // Confirm booking
                System.out.println("Booking Confirmed!");
                System.out.println("Guest: " + request.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println("Room ID: " + roomId);
            } else {
                System.out.println("Booking Failed (No Availability)");
            }

            System.out.println();
        }
    }

    // Unique Room ID generator
    private String generateRoomId(String roomType) {
        int count = allocatedRooms.getOrDefault(roomType, new HashSet<>()).size() + 1;
        return roomType.substring(0, 1).toUpperCase() + count;
    }
}