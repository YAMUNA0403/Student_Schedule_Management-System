import java.io.Serializable;
import java.time.LocalDateTime;

public class ProgressRecord implements Serializable {
    private String subject;
    private LocalDateTime dateTime;
    private double progressPercentage;

    public ProgressRecord(String subject, LocalDateTime dateTime, double progressPercentage) {
        this.subject = subject;
        this.dateTime = dateTime;
        this.progressPercentage = progressPercentage;
    }

    // Getters and setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    @Override
    public String toString() {
        return "ProgressRecord{" +
                "subject='" + subject + '\'' +
                ", dateTime=" + dateTime +
                ", progressPercentage=" + progressPercentage +
                '}';
    }
}
