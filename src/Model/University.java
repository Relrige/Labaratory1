package src.Model;

import src.Helper.*;

/**
 * Represents a University entity with faculties, students, and teachers.
 */
public class University {
    /** The list of faculties in the university. */
    public static ArrayList<Faculty> facultyArrayList;

    /** The list of students across all faculties in the university. */
    public static ArrayList<Student> uniStudentArrayList;

    /** The list of teachers across all faculties in the university. */
    public static ArrayList<Teacher> uniTeacherArrayList;

    /** The name of the university. */
    String name = "TNU";

    /**
     * Default constructor for the University class.
     */
    public University(){

    }

    /**
     * Seeds the system with initial faculties.
     * Adds pre-defined faculties to the system.
     */
    public static void seedFaculty() {
        facultyArrayList=new ArrayList<>();
        facultyArrayList.add(new Faculty("FI"));
        facultyArrayList.add(new Faculty("FSNST"));
        facultyArrayList.add(new Faculty("FGN"));
        facultyArrayList.add(new Faculty("FVN"));
        facultyArrayList.add(new Faculty("FPRN"));
    }

    /**
     * Creates a new faculty and adds it to the system.
     * Prompts the user for the name of the new faculty.
     * If any errors occur during the process, they are caught and printed.
     */
    public void createFaculty() {
        try {
            // Prompting for faculty details
            String name = DataInput.getString("Enter the name of the new faculty: ");
            // Creating the new faculty object
            Faculty newFaculty = new Faculty(name);
            facultyArrayList.add(newFaculty);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Edits the details of an existing faculty.
     * Prompts the user for the faculty's name to find it.
     * Then, provides an option to edit the faculty's name.
     * If any errors occur during the process, they are caught and printed.
     */
    public void editFaculty() {
        try {
            // Finding the faculty to edit
            Faculty toEdit = findFaculty(DataInput.getString("Enter the name of a faculty you want to change: "));
            // Editing the faculty's name
            toEdit.setName(DataInput.getString("Enter a new name for a faculty: "));
        } catch (Exception e) {
            // Catching and printing any exceptions that occur
            System.err.println(e);
        }
    }
    /**
     * Prints the details of all faculties in the university.
     */
    public static void printArray() {
        for (int i = 0; i < facultyArrayList.size(); i++) {
            Faculty faculty = facultyArrayList.get(i);
            System.out.println(faculty); // Assuming there is a meaningful toString() method in Cafedra class
        }
    }

    /**
     * Removes the specified faculty from the system.
     * This method removes the faculty from the faculty list and clears its associated student, teacher, and cafedra lists.
     *
     * @param faculty The faculty to be removed.
     */
    public void removeFaculty(Faculty faculty) {
        // Removing the faculty from lists
        facultyArrayList.remove(faculty);
        faculty.getFacultyStudentArrayList().clear();
        faculty.getFacultyTeacherArrayList().clear();
        faculty.getCafedraArrayList().clear();
        faculty = null;
    }

    /**
     * Finds a faculty based on its name.
     *
     * @param facultyName The name of the faculty to find.
     * @return The faculty object if found, otherwise null.
     */
    public static Faculty findFaculty(String facultyName) {
        if(facultyArrayList==null){
            System.out.println("Empty faculty arrayList");
            return null;
        }
        for (int i = 0; i < facultyArrayList.size(); i++) {
            Faculty faculty = facultyArrayList.get(i);
            if (facultyName.equalsIgnoreCase(faculty.getName())) {
                return faculty;
            }
        }
        return null;
    }
}
