import java.time.LocalDateTime;

public class ScheduleItem {
    private String title;
    private LocalDateTime dateTime;
    private String description;

    public ScheduleItem(String title, LocalDateTime dateTime, String description) {
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }
}
