public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Room Allocation System\n");

        // Step 1: Create inventory (UC-4)
        RoomInventory inventory = new RoomInventory();

        // Step 2: Create booking queue (UC-5)
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add booking requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Double"));
        queue.addRequest(new Reservation("Kumar", "Single"));
        queue.addRequest(new Reservation("Ravi", "Suite"));
        queue.addRequest(new Reservation("Priya", "Single")); // may fail if no availability

        // Step 3: Allocate rooms (UC-6)
        RoomAllocationService service = new RoomAllocationService();

        service.processBookingRequests(queue, inventory);
    }
}