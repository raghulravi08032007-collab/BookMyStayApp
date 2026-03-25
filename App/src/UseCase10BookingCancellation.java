
import java.util.*;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation & Rollback\n");

        // Step 1: Inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Simulate allocated rooms (from UC-6)
        Map<String, Set<String>> allocatedRooms = new HashMap<>();

        allocatedRooms.put("Single", new HashSet<>(Arrays.asList("S1", "S2")));
        allocatedRooms.put("Double", new HashSet<>(Arrays.asList("D1")));

        // Step 3: Cancellation service
        CancellationService service = new CancellationService(allocatedRooms);

        // Step 4: Perform cancellations
        service.cancelBooking("Single", "S1", inventory); // valid
        service.cancelBooking("Double", "D1", inventory); // valid
        service.cancelBooking("Suite", "S1", inventory);  // invalid

        // Step 5: Show rollback history
        service.showRollbackStack();
    }
}