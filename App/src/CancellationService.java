
import java.util.*;

public class CancellationService {

    private Map<String, Set<String>> allocatedRooms;
    private Stack<String> rollbackStack;

    public CancellationService(Map<String, Set<String>> allocatedRooms) {
        this.allocatedRooms = allocatedRooms;
        this.rollbackStack = new Stack<>();
    }

    public void cancelBooking(String roomType, String roomId, RoomInventory inventory) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Cancelling Booking: " + roomId);

        // Validate existence
        if (!allocatedRooms.containsKey(roomType) ||
                !allocatedRooms.get(roomType).contains(roomId)) {

            System.out.println("Error ❌: Booking does not exist\n");
            return;
        }

        // Remove room ID (release allocation)
        allocatedRooms.get(roomType).remove(roomId);

        // Push to rollback stack
        rollbackStack.push(roomId);

        // Restore inventory
        availability.put(roomType, availability.get(roomType) + 1);

        System.out.println("Cancellation Successful ✅");
        System.out.println("Room Released: " + roomId);
        System.out.println("Updated Availability: " + availability.get(roomType));
        System.out.println();
    }

    public void showRollbackStack() {
        System.out.println("Rollback Stack (Recent Releases): " + rollbackStack);
    }
}