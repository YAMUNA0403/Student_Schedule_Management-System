import java.io.Serializable;

public class StudyMaterial implements Serializable {
    private String title;
    private String content;
    private String subject;

    public StudyMaterial(String title, String content, String subject) {
        this.title = title;
        this.content = content;
        this.subject = subject;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "StudyMaterial{" +
                "title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
