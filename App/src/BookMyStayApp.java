/**
 * =========================================================
 * BOOK MY STAY APP (ALL-IN-ONE)
 * Use Case 3: Centralized Room Inventory Management
 * =========================================================
 */

import java.util.HashMap;
import java.util.Map;

// ================= ROOM ABSTRACT CLASS =================
abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sq.ft");
        System.out.println("Price: ₹" + pricePerNight + " per night");
    }
}

// ================= SINGLE ROOM =================
class SingleRoom {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

// ================= DOUBLE ROOM =================
class DoubleRoom {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

// ================= SUITE ROOM =================
class SuiteRoom {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

// ================= ROOM INVENTORY =================
class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

// ================= MAIN CLASS =================
public class BookMyStayApp {

    public static void main(String[] args) {

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("===== Room Inventory Details =====");

        System.out.println("\nSingle Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + inventory.getRoomAvailability().get("Single"));

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + inventory.getRoomAvailability().get("Double"));

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + inventory.getRoomAvailability().get("Suite"));

        // Update example
        inventory.updateAvailability("Single", 4);

        System.out.println("\nAfter Booking 1 Single Room:");
        System.out.println("Single Rooms Available: " +
                inventory.getRoomAvailability().get("Single"));

        System.out.println("\nApplication Finished.");
    }
}