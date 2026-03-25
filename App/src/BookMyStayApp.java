/**
 * =========================================================
 UC-2
 * MAIN CLASS - BookMyStayApp
 * =========================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * @version 2.1
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        // Create room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("===== Room Details =====");

        System.out.println("\nSingle Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);

        System.out.println("\nApplication Finished.");
    }
}