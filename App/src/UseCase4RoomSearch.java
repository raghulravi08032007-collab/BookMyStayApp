public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room singleRoom = new Room("Single", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double", 2, 400, 2500.0);
        Room suiteRoom = new Room("Suite", 3, 750, 5000.0);

        // Create service
        RoomSearchService service = new RoomSearchService();

        // Perform search
        service.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}