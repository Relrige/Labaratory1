package src.Model;

import lombok.Data;
import src.Helper.ArrayList;
import src.Helper.DataInput;

import java.io.IOException;

import static src.Model.Faculty.findCafedra;
import static src.Model.Faculty.printArray;

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

    public static void createStudent() {
        try {
            String surname = DataInput.getString("Enter the surname of the new student: ");
            String name = DataInput.getString("Enter the name of the new student: ");
            String FatherName = DataInput.getString("Enter the FatherName of the new student: ");
            Cafedra cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            String group = DataInput.getString("Enter group a new student: ");
            int course = DataInput.getInt("Enter course of a new student: ");
            while (course <= 0 || course > 6) {
                System.out.println("Enter a valid value for course (1-6)");
                course = DataInput.getInt("Enter course of a new student: ");
            }
            Student newStudent = new Student( cafedra,name,surname,FatherName, course, group);
            System.out.println(newStudent);
            University.uniStudentArrayList.add(newStudent);
            cafedra.getStudentArrayList().add(newStudent);
            cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
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
    public static Student findStudent(int course) {
        for (int i = 0; i < University.uniStudentArrayList.size(); i++) {
            Student student = University.uniStudentArrayList.get(i);
            if (course==student.getCourse()) {
                return student;
            }
        }
        return null;
    }
    public static Student findStudent(String studentName,String surName,String fatherName) {
        for (int i = 0; i < University.uniStudentArrayList.size(); i++) {
            Student student = University.uniStudentArrayList.get(i);
            if (studentName.equalsIgnoreCase(student.getName())||surName.equalsIgnoreCase(student.getSurname())||fatherName.equalsIgnoreCase(student.getFatherName())) {
                return student;
            }
        }
        return null;
    }
    public static void removeStudent(Student student){
        student.getCafedra().getStudentArrayList().remove(student);
        student.getCafedra().getFaculty().getFacultyStudentArrayList().remove(student);
        University.uniStudentArrayList.remove(student);

    }
    public static void createTeacher() {
        try {
            String surname = DataInput.getString("Enter the surname of the new teacher: ");
            String name = DataInput.getString("Enter the name of the new teacher: ");
            String FatherName = DataInput.getString("Enter the FatherName of the new teacher: ");

            printArray();
            Cafedra cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));

            Teacher newStudent = new Teacher(cafedra,name,surname,FatherName);
            System.out.println(newStudent);
            cafedra.getTeacherArrayList().add(newStudent);
            cafedra.getFaculty().getFacultyTeacherArrayList().add(newStudent);
            University.uniTeacherArrayList.add(newStudent);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
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
    public static Teacher findTeacher(String studentName,String surName,String fatherName) {
        for (int i = 0; i < University.uniTeacherArrayList.size(); i++) {
            Teacher teacher = University.uniTeacherArrayList.get(i);
            if (studentName.equalsIgnoreCase(teacher.getName())||surName.equalsIgnoreCase(teacher.getSurname())||fatherName.equalsIgnoreCase(teacher.getFatherName())) {
                return teacher;
            }
        }
        return null;
    }
    public static void removeTeacher(Teacher teacher){
        teacher.getCafedra().getTeacherArrayList().remove(teacher);
        teacher.getCafedra().getFaculty().getFacultyTeacherArrayList().remove(teacher);
        University.uniTeacherArrayList.remove(teacher);

    }
    public String toString(){
        return "Cafedra of the " + faculty +" faculty: "+name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
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
