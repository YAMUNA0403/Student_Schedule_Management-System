import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class NotificationManager {
    private Timer timer;

    public NotificationManager() {
        timer = new Timer(true);
    }

    public void setAlarm(LocalDateTime dateTime) {
        scheduleNotification("Alarm", dateTime);
    }

    public void scheduleNotification(String title, LocalDateTime dateTime) {
        long delay = LocalDateTime.now().until(dateTime, ChronoUnit.MILLIS);
        if (delay > 0) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    showNotification(title);
                    playAlarmSound();
                }
            }, delay);
        }
    }

    private void showNotification(String message) {
        JOptionPane.showMessageDialog(null, message, "Reminder", JOptionPane.INFORMATION_MESSAGE);
    }

    private void playAlarmSound() {
        try {
            File soundFile = new File("alarm.wav"); // Specify the path to your alarm sound file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
