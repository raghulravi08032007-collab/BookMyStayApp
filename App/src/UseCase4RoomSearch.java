public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Create service
        RoomSearchService service = new RoomSearchService();

        // Search available rooms
        service.searchAvailableRooms(
                inventory,
                single,
                doubleRoom,
                suite
        );
    }
}