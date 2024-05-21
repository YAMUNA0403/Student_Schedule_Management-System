import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<ScheduleItem> scheduleItems = new ArrayList<>();

    public void addScheduleItem(ScheduleItem item) {
        scheduleItems.add(item);
    }

    public List<ScheduleItem> getScheduleItems() {
        return new ArrayList<>(scheduleItems);
    }
}
