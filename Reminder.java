import java.io.Serializable;
import java.time.LocalDateTime;

public class Reminder implements Serializable {
    private String title;
    private LocalDateTime dateTime;
    private String description;

    public Reminder(String title, LocalDateTime dateTime, String description) {
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "title='" + title + '\'' +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
