public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("Data Persistence & Recovery\n");

        PersistenceService service = new PersistenceService();

        // Load existing data
        Object[] data = service.loadData();

        RoomInventory inventory = (RoomInventory) data[0];
        BookingHistory history = (BookingHistory) data[1];

        // Simulate booking
        Reservation r1 = new Reservation("Abhi", "Single");
        history.addReservation(r1);

        System.out.println("Added booking for: " + r1.getGuestName());

        // Save data
        service.saveData(inventory, history);
    }
}