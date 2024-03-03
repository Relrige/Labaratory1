package src.Model;

import lombok.Data;
import src.Helper.ArrayList;
import src.Helper.DataInput;

import static src.Model.University.findFaculty;

@Data
public class Faculty {
    private String name;
    public static ArrayList<Cafedra> cafedraArrayList;
    private  ArrayList<Student> facultyStudentArrayList;
    private  ArrayList<Teacher> facultyTeacherArrayList;


    public Faculty(String name) {
        this.name=name;
        this.facultyStudentArrayList=new ArrayList<>();
        this.facultyTeacherArrayList=new ArrayList<>();
    }
    /**
     * Seeds the system with initial cafedras.
     * Adds pre-defined cafedras to the system, including their respective faculties.
     */
    public static void seedCafedra() {
        cafedraArrayList=new ArrayList<>();
        cafedraArrayList.add(new Cafedra("Cafedra FI", University.findFaculty("FI")));
        cafedraArrayList.add(new Cafedra("Cafedra FI2", University.findFaculty("FI")));
        cafedraArrayList.add(new Cafedra("Cafedra FI3", University.findFaculty("FI")));
        cafedraArrayList.add(new Cafedra("Cafedra FI4", University.findFaculty("FI")));
        cafedraArrayList.add(new Cafedra("Cafedra FI5", University.findFaculty("FSNT")));
    }
    /**
     * Creates a new cafedra and adds it to the system.
     * Prompts the user for necessary information such as name and associated faculty.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void createCafedra() {
        try {
            String name = DataInput.getString("Enter the name of the new cafedra: ");
            Faculty faculty = findFaculty(DataInput.getString("Enter a name of an existing faculty: "));
            if(faculty==null){
                System.out.println("Faculty not found");
                return;
            }
            Cafedra newCafedra = new Cafedra(name, faculty);
            cafedraArrayList.add(newCafedra);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Edits the details of an existing cafedra.
     * Prompts the user for the cafedra's name to find it.
     * Then, provides an option to edit the cafedra's name.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void editCafedra() {
        try {
            Cafedra toEdit = findCafedra(DataInput.getString("Enter the name of a cafedra you want to change: "));
            if (toEdit == null) {
                System.out.println("Cafedra not found");
                return;
            }
            toEdit.setName(DataInput.getString("Enter a new name for a cafedra: "));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Finds a cafedra based on its name.
     *
     * @param cafedraName The name of the cafedra to find.
     * @return The cafedra object if found, otherwise null.
     */
    public static Cafedra findCafedra(String cafedraName) {
        if(cafedraArrayList==null){
            System.out.println("Empty cafedra arrayList");
            return null;
        }
        for (int i = 0; i < cafedraArrayList.size(); i++) {
            Cafedra cafedra = cafedraArrayList.get(i);
            if (cafedraName.equalsIgnoreCase(cafedra.getName())) {
                return cafedra;
            }
        }
        return null;
    }
    /**
     * Removes the specified cafedra from the system.
     * This method removes the cafedra from the cafedra list, clears its associated student and teacher lists,
     * and removes any associated students and teachers from the university-wide lists.
     *
     * @param cafedra The cafedra to be removed.
     */
    public static void removeCafedra(Cafedra cafedra){
        cafedraArrayList.remove(cafedra);
        cafedra.getStudentArrayList().clear();
        cafedra.getTeacherArrayList().clear();
        for (int i = 0; i < cafedra.getFaculty().getFacultyStudentArrayList().size(); i++) {
            Student student = (Student) cafedra.getFaculty().getFacultyStudentArrayList().get(i);
            if(student.getCafedra().equals(cafedra)){
                cafedra.getFaculty().getFacultyStudentArrayList().remove(student);
            }
        }
        for (int i = 0; i < cafedra.getFaculty().getFacultyTeacherArrayList().size(); i++) {
            Teacher teacher = (Teacher) cafedra.getFaculty().getFacultyTeacherArrayList().get(i);
            if(teacher.getCafedra().equals(cafedra)){
                cafedra.getFaculty().getFacultyTeacherArrayList().remove(teacher);
            }
        }
        for (int i = 0; i < University.uniStudentArrayList.size(); i++) {
            Student student = (Student)  University.uniStudentArrayList.get(i);
            if(student.getCafedra().equals(cafedra)){
                University.uniStudentArrayList.remove(student);
            }
        }
        for (int i = 0; i <  University.uniTeacherArrayList.size(); i++) {
            Teacher teacher = (Teacher)  University.uniTeacherArrayList.get(i);
            if(teacher.getCafedra().equals(cafedra)){
                University.uniTeacherArrayList.remove(teacher);
            }
        }

        cafedra = null;
    }

    public static void printArray() {
        if(cafedraArrayList!=null) {
            for (int i = 0; i < cafedraArrayList.size(); i++) {
                Cafedra cafedra = cafedraArrayList.get(i);
                System.out.println(cafedra);
            }
        }else
        {
            System.out.println("Empty cafedra arrayList");
        }
    }

    public ArrayList getFacultyStudentArrayList() {
        return facultyStudentArrayList;
    }
    public ArrayList getFacultyTeacherArrayList() {
        return facultyTeacherArrayList;
    }
    public ArrayList getCafedraArrayList() {
        return cafedraArrayList;
    }

}