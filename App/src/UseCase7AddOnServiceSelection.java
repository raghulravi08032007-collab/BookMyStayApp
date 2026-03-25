public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection\n");

        // Example reservation IDs (from UC-6)
        String r1 = "S1";
        String r2 = "D1";

        // Create service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        AddOnService wifi = new AddOnService("WiFi", 200);
        AddOnService breakfast = new AddOnService("Breakfast", 300);
        AddOnService parking = new AddOnService("Parking", 150);

        // Add services to reservations
        manager.addService(r1, wifi);
        manager.addService(r1, breakfast);

        manager.addService(r2, parking);

        // Display services
        System.out.println("Reservation ID: " + r1);
        manager.displayServices(r1);

        System.out.println();

        System.out.println("Reservation ID: " + r2);
        manager.displayServices(r2);
    }
}