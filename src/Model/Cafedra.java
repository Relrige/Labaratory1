package src.Model;

import lombok.Data;
import src.Helper.*;

import java.io.IOException;
import java.util.Objects;

import static src.Model.Faculty.findCafedra;
import static src.Model.Faculty.printArray;
/**
 * Represents a department (Cafedra) within a faculty.
 */
@Data
public class Cafedra {
    private final Faculty faculty;
    private String name;
    ArrayList<Student> studentArrayList;
    ArrayList<Teacher> teacherArrayList;
    public Cafedra(Faculty faculty) {
        this.faculty = faculty;
        studentArrayList=new ArrayList<>();
        teacherArrayList=new ArrayList<>();
    }
    public Cafedra(String name, Faculty faculty) {
        this.name=name;
        this.faculty=faculty;
        studentArrayList=new ArrayList<>();
        teacherArrayList=new ArrayList<>();
    }
    public static boolean containsDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Creates a new student and adds it to the system.
     * Prompts the user for necessary information such as name, surname, father's name, department, group, and course.
     * Once the student is created, it is added to the appropriate lists.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void createStudent() {
        try {
            String surname;
            do {
                surname = DataInput.getString("Enter the surname of the new student: ");
                if (containsDigit(surname)) {
                    System.out.println("Surname should not contain digits. Please enter a valid surname.");
                }
            } while (containsDigit(surname));
            String name;
            do {
                name = DataInput.getString("Enter the name of the new student: ");
                if (containsDigit(name)) {
                    System.out.println("Name should not contain digits. Please enter a valid name.");
                }
            } while (containsDigit(name));

            String fatherName;
            do {
                fatherName = DataInput.getString("Enter the father's name of the new student: ");
                if (containsDigit(fatherName)) {
                    System.out.println("Father's name should not contain digits. Please enter a valid father's name.");
                }
            } while (containsDigit(fatherName));
            printArray();
            Cafedra cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            while (cafedra==null) {
                System.out.println("Enter a valid value for cafedra");
                cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            }
            String group = DataInput.getString("Enter group a new student: ");
            int course = DataInput.getInt("Enter course of a new student: ");
            while (course <= 0 || course > 6) {
                System.out.println("Enter a valid value for course (1-6)");
                course = DataInput.getInt("Enter course of a new student: ");
            }
            Student newStudent = new Student( cafedra,name,surname,fatherName, course, group);
            System.out.println(newStudent);
            University.uniStudentArrayList.add(newStudent);
            cafedra.getStudentArrayList().add(newStudent);
            cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Edits the details of an existing student.
     * Prompts the user for the student's name, surname, and father's name to find the student.
     * Then, provides options to edit the student's name, department, year of study, and group.
     * Prints the updated student details after editing.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void editStudent() {
        try {
            Student toEdit = findStudent(DataInput.getString("Enter a name of an existing student: "),
                    DataInput.getString("Enter a surName of an existing student: "),
                    DataInput.getString("Enter a fatherName of an existing student: "));
            System.out.println(toEdit);
            if (DataInput.getChar("Do you want to change name? (y/a): ") == 'y')
                toEdit.setName(DataInput.getString("> "));
            if (DataInput.getChar("Do you want to change cafedra? (y/a): ") == 'y') {
                printArray();
                toEdit.setCafedra(findCafedra(DataInput.getString("Enter a name of an existing faculty: ")));
            }
            if (DataInput.getChar("Do you want to change year of studying? (y/a): ") == 'y')
                toEdit.setCourse(DataInput.checkInt(DataInput.getInt("> "), 0, 6));
            if (DataInput.getChar("Do you want to change group? (y/a): ") == 'y')
                toEdit.setGroup(DataInput.getString("> "));
            System.out.println(toEdit);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Finds a student based on their course.
     *
     * @param course The course of the student to find.
     * @return The student object if found, otherwise null.
     */
    public static void findStudent(int course) {
        int counter=0;
        for (int i = 0; i < University.uniStudentArrayList.size(); i++) {
            Student student = University.uniStudentArrayList.get(i);
            if (course==student.getCourse()) {
                System.out.println(student);
                counter++;
            }
        }
        if(counter==0)
            System.out.println("No students found");
    }    /**
     * Finds a student based on their course.
     *
     * @param group The group of the student to find.
     * @return The student object if found, otherwise null.
     */
    public static void findStudent(String group) {
        int counter=0;
        for (int i = 0; i < University.uniStudentArrayList.size(); i++) {
            Student student = University.uniStudentArrayList.get(i);
            if (Objects.equals(group, student.getGroup())) {
                System.out.println(student);
                counter++;
            }
        }
        if(counter==0)
            System.out.println("No students found");
    }
    /**
     * Finds a student based on their name, surname, and father's name.
     *
     * @param studentName The name of the student to find.
     * @param surName     The surname of the student to find.
     * @param fatherName  The father's name of the student to find.
     * @return The student object if found, otherwise null.
     */
    public static Student findStudent(String studentName,String surName,String fatherName) {
        for (int i = 0; i < University.uniStudentArrayList.size(); i++) {
            Student student = University.uniStudentArrayList.get(i);
            if (studentName.equalsIgnoreCase(student.getName())&&surName.equalsIgnoreCase(student.getSurname())&&fatherName.equalsIgnoreCase(student.getFatherName())) {
                return student;
            }
        }

        System.out.println("No students found");
        return null;
    }
    /**
     * Removes the specified student from all relevant lists.
     * This method removes the student from the student list of their cafedra,
     * removes them from the student list of their faculty,
     * and removes them from the university-wide student list.
     *
     * @param student The student to be removed.
     */
    public static void removeStudent(Student student){
        student.getCafedra().getStudentArrayList().remove(student);
        student.getCafedra().getFaculty().getFacultyStudentArrayList().remove(student);
        University.uniStudentArrayList.remove(student);
    }
    /**
     * Creates a new teacher and adds them to the system.
     * Prompts the user for necessary information such as name, surname, father's name, and department.
     * Once the teacher is created, they are added to the appropriate lists.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void createTeacher() {
        try {
            String surname;
            do {
                surname = DataInput.getString("Enter the surname of the new student: ");
                if (containsDigit(surname)) {
                    System.out.println("Surname should not contain digits. Please enter a valid surname.");
                }
            } while (containsDigit(surname));
            String name;
            do {
                name = DataInput.getString("Enter the name of the new student: ");
                if (containsDigit(name)) {
                    System.out.println("Name should not contain digits. Please enter a valid name.");
                }
            } while (containsDigit(name));
            String fatherName;
            do {
                fatherName = DataInput.getString("Enter the father's name of the new student: ");
                if (containsDigit(fatherName)) {
                    System.out.println("Father's name should not contain digits. Please enter a valid father's name.");
                }
            } while (containsDigit(fatherName));
            printArray();
            Cafedra cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            while (cafedra==null) {
                System.out.println("Enter a valid value for cafedra");
                cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            }
            Teacher newStudent = new Teacher(cafedra,name,surname,fatherName);
            System.out.println(newStudent);
            cafedra.getTeacherArrayList().add(newStudent);
            cafedra.getFaculty().getFacultyTeacherArrayList().add(newStudent);
            University.uniTeacherArrayList.add(newStudent);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Edits the details of an existing teacher.
     * Prompts the user for the teacher's name, surname, and father's name to find the teacher.
     * Then, provides options to edit the teacher's name, department.
     * Prints the updated teacher details after editing.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void editTeacher() {
        try {
            Teacher toEdit = findTeacher(DataInput.getString("Enter a name of an existing teacher: "),
                    DataInput.getString("Enter a surName of an existing teacher: "),
                    DataInput.getString("Enter a fatherName of an existing teacher: "));
            if(toEdit==null){
                System.out.println("Teacher not found");
                return;
            }
            System.out.println(toEdit);
            if (DataInput.getChar("Do you want to change name? (y/a): ") == 'y')
                toEdit.setName(DataInput.getString("> "));
            if (DataInput.getChar("Do you want to change cafedra? (y/a): ") == 'y') {
                printArray();
                toEdit.setCafedra(findCafedra(DataInput.getString("Enter a name of an existing faculty: ")));
            }
            System.out.println(toEdit);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Finds a teacher based on their name, surname, and father's name.
     *
     * @param studentName The name of the teacher to find.
     * @param surName     The surname of the teacher to find.
     * @param fatherName  The father's name of the teacher to find.
     * @return The teacher object if found, otherwise null.
     */
    public static Teacher findTeacher(String studentName,String surName,String fatherName) {
        for (int i = 0; i < University.uniTeacherArrayList.size(); i++) {
            Teacher teacher = University.uniTeacherArrayList.get(i);
            if (studentName.equalsIgnoreCase(teacher.getName())&&surName.equalsIgnoreCase(teacher.getSurname())&&fatherName.equalsIgnoreCase(teacher.getFatherName())) {
                return teacher;
            }
        }
        System.out.println("No teachers found");
        return null;
    }
    /**
     * Removes the specified teacher from all relevant lists.
     * This method removes the teacher from the teacher list of their cafedra,
     * removes them from the teacher list of their faculty,
     * and removes them from the university-wide teacher list.
     *
     * @param teacher The teacher to be removed.
     */
    public static void removeTeacher(Teacher teacher){
        teacher.getCafedra().getTeacherArrayList().remove(teacher);
        teacher.getCafedra().getFaculty().getFacultyTeacherArrayList().remove(teacher);
        University.uniTeacherArrayList.remove(teacher);

    }

    public String toString(){
        return "Cafedra of the " + faculty +" faculty: "+name;
    }

    public ArrayList getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public ArrayList getTeacherArrayList() {
        return teacherArrayList;
    }

    public void setTeacherArrayList(ArrayList teacherArrayList) {
        this.teacherArrayList = teacherArrayList;
    }
}
