import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudyMaterialManager {
    private List<StudyMaterial> studyMaterials;
    private final String filename = "studyMaterials.dat";

    public StudyMaterialManager() {
        studyMaterials = new ArrayList<>();
        loadStudyMaterials();
    }

    public void addStudyMaterial(StudyMaterial material) {
        studyMaterials.add(material);
        saveStudyMaterials();
    }

    public List<StudyMaterial> getStudyMaterials() {
        return new ArrayList<>(studyMaterials);
    }

    public void deleteStudyMaterial(String title) {
        studyMaterials.removeIf(material -> material.getTitle().equals(title));
        saveStudyMaterials();
    }

    private void saveStudyMaterials() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(studyMaterials);
        } catch (IOException e) {
            System.out.println("Error saving study materials: " + e.getMessage());
        }
    }

    private void loadStudyMaterials() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            studyMaterials = (List<StudyMaterial>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing study materials found. Starting fresh.");
        }
    }
}
