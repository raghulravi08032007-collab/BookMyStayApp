public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation\n");

        // Shared resources
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add booking requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Kumar", "Single"));
        queue.addRequest(new Reservation("Ravi", "Single"));
        queue.addRequest(new Reservation("Priya", "Single"));

        // Processor
        ConcurrentBookingProcessor processor =
                new ConcurrentBookingProcessor(queue, inventory);

        // Create multiple threads (simulate users)
        Thread t1 = new Thread(() -> {
            while (queue.hasPendingRequests()) {
                processor.processBooking();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            while (queue.hasPendingRequests()) {
                processor.processBooking();
            }
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            while (queue.hasPendingRequests()) {
                processor.processBooking();
            }
        }, "Thread-3");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}