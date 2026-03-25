public class ConcurrentBookingProcessor {

    private BookingRequestQueue queue;
    private RoomInventory inventory;

    public ConcurrentBookingProcessor(BookingRequestQueue queue, RoomInventory inventory) {
        this.queue = queue;
        this.inventory = inventory;
    }

    // Critical section (synchronized)
    public synchronized void processBooking() {

        if (!queue.hasPendingRequests()) {
            return;
        }

        Reservation request = queue.getNextRequest();
        String roomType = request.getRoomType();

        System.out.println(Thread.currentThread().getName() +
                " processing " + request.getGuestName());

        int available = inventory.getRoomAvailability().get(roomType);

        if (available > 0) {
            inventory.getRoomAvailability().put(roomType, available - 1);

            System.out.println("Booking Confirmed ✅ for " +
                    request.getGuestName() + " (" + roomType + ")");
        } else {
            System.out.println("Booking Failed ❌ for " +
                    request.getGuestName() + " (No rooms)");
        }

        System.out.println();
    }
}