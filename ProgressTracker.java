import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProgressTracker {
    private List<ProgressRecord> progressRecords;
    private final String filename = "progressRecords.dat";

    public ProgressTracker() {
        progressRecords = new ArrayList<>();
        loadProgressRecords();
    }

    public void addProgressRecord(ProgressRecord record) {
        progressRecords.add(record);
        saveProgressRecords();
    }

    public List<ProgressRecord> getProgressRecords() {
        return new ArrayList<>(progressRecords);
    }

    public void generateReport() {
        for (ProgressRecord record : progressRecords) {
            System.out.println(record);
        }
    }

    private void saveProgressRecords() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(progressRecords);
        } catch (IOException e) {
            System.out.println("Error saving progress records: " + e.getMessage());
        }
    }

    private void loadProgressRecords() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            progressRecords = (List<ProgressRecord>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing progress records found. Starting fresh.");
        }
    }
}
