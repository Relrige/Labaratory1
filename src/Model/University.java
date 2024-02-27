package src.Model;

import lombok.Data;
import src.Helper.ArrayList;
import src.Helper.DataInput;

@Data
public class University {
    public static ArrayList<Faculty> facultyArrayList;
    public static ArrayList<Student> uniStudentArrayList;
    public static ArrayList<Teacher> uniTeacherArrayList;

    String name = "TNU";
    public University(){
        facultyArrayList=new ArrayList<>();
    }


    public void createFaculty() {
        try {
            String name = DataInput.getString("Enter the name of the new faculty: ");
            Faculty newFaculty = new Faculty(name);
            facultyArrayList.add(newFaculty);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void editFaculty() {
        try {
            Faculty toEdit = findFaculty(DataInput.getString("Enter the name of a faculty you want to change: "));
            toEdit.setName(DataInput.getString("Enter a new name for a faculty: "));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void printArray() {
        for (int i = 0; i < facultyArrayList.size(); i++) {
            Faculty faculty = facultyArrayList.get(i);
            System.out.println(faculty); // Assuming there is a meaningful toString() method in Cafedra class
        }
    }

    public void removeFaculty(Faculty faculty) {
        facultyArrayList.remove(faculty);
    }

    public static Faculty findFaculty(String facultyName) {
        for (int i = 0; i < facultyArrayList.size(); i++) {
            Faculty faculty = facultyArrayList.get(i);
            if (facultyName.equalsIgnoreCase(faculty.getName())) {
                return faculty;
            }
        }
        return null;
    }
}
