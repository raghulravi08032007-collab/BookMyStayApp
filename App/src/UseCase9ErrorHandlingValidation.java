public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("Error Handling & Validation\n");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Validator
        BookingValidator validator = new BookingValidator();

        // Test cases
        Reservation r1 = new Reservation("Abhi", "Single");   // valid
        Reservation r2 = new Reservation("", "Double");       // invalid name
        Reservation r3 = new Reservation("Kumar", "Luxury");  // invalid room

        Reservation[] requests = {r1, r2, r3};

        for (Reservation r : requests) {
            try {
                System.out.println("Processing: " + r.getGuestName() + " - " + r.getRoomType());

                validator.validate(r, inventory);

                System.out.println("Booking is valid ✅\n");

            } catch (InvalidBookingException e) {
                System.out.println("Error ❌: " + e.getMessage() + "\n");
            }
        }
    }
}