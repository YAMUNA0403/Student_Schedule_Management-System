import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderManager {
    private List<Reminder> reminders;
    private final String filename = "reminders.dat";
    private Timer timer;

    public ReminderManager() {
        reminders = new ArrayList<>();
        timer = new Timer(true);
        loadReminders();
        scheduleReminders();
    }

    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
        saveReminders();
        scheduleReminder(reminder);
    }

    public List<Reminder> getReminders() {
        return new ArrayList<>(reminders);
    }

    public void deleteReminder(String title) {
        reminders.removeIf(reminder -> reminder.getTitle().equals(title));
        saveReminders();
    }

    private void saveReminders() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(reminders);
        } catch (IOException e) {
            System.out.println("Error saving reminders: " + e.getMessage());
        }
    }

    private void loadReminders() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            reminders = (List<Reminder>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing reminders found. Starting fresh.");
        }
    }

    private void scheduleReminders() {
        for (Reminder reminder : reminders) {
            scheduleReminder(reminder);
        }
    }

    private void scheduleReminder(Reminder reminder) {
        long delay = reminder.getDateTime().atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli()
                - System.currentTimeMillis();
        if (delay > 0) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Reminder: " + reminder.getTitle() + " - " + reminder.getDescription());
                }
            }, delay);
        }
    }
}
