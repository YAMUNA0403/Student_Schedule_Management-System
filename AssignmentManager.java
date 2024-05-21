import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AssignmentManager {
    private List<Assignment> assignments;
    private final String filename = "assignments.dat";

    public AssignmentManager() {
        assignments = new ArrayList<>();
        loadAssignments();
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
        saveAssignments();
    }

    public List<Assignment> getAssignments() {
        return new ArrayList<>(assignments);
    }

    public void markAsCompleted(String title) {
        for (Assignment a : assignments) {
            if (a.getTitle().equals(title)) {
                a.setCompleted(true);
                saveAssignments();
                return;
            }
        }
    }

    public void deleteAssignment(String title) {
        assignments.removeIf(assignment -> assignment.getTitle().equals(title));
        saveAssignments();
    }

    private void saveAssignments() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(assignments);
        } catch (IOException e) {
            System.out.println("Error saving assignments: " + e.getMessage());
        }
    }

    private void loadAssignments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            assignments = (List<Assignment>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing assignments found. Starting fresh.");
        }
    }
}
