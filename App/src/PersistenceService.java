import java.io.*;

public class PersistenceService {

    private static final String FILE_NAME = "system_state.ser";

    // Save data
    public void saveData(RoomInventory inventory, BookingHistory history) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(inventory);
            out.writeObject(history);

            System.out.println("Data saved successfully ✅");

        } catch (IOException e) {
            System.out.println("Error saving data ❌: " + e.getMessage());
        }
    }

    // Load data
    public Object[] loadData() {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            RoomInventory inventory = (RoomInventory) in.readObject();
            BookingHistory history = (BookingHistory) in.readObject();

            System.out.println("Data loaded successfully ✅");

            return new Object[]{inventory, history};

        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh ⚠️");

            return new Object[]{new RoomInventory(), new BookingHistory()};
        }
    }
}