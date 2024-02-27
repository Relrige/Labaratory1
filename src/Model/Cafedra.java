package src.Model;

import lombok.Data;
import src.Helper.ArrayList;
import src.Helper.DataInput;

import java.io.IOException;

import static src.Model.Faculty.findCafedra;
import static src.Model.Faculty.printArray;

@Data
public class Cafedra {
    private String name;
    static ArrayList<Student> studentArrayList;
    static ArrayList<Teacher> teacherArrayList;
    public Cafedra() {
        studentArrayList=new ArrayList<>();
        teacherArrayList=new ArrayList<>();
    }

    public Cafedra(String name) {
        this.name=name;
        studentArrayList=new ArrayList<>();
        teacherArrayList=new ArrayList<>();
    }

    public static void createStudent() {
        try {
            String name = DataInput.getString("Enter the name of the new student: ");
            String surname = DataInput.getString("Enter the surname of the new student: ");
            String FatherName = DataInput.getString("Enter the FatherName of the new student: ");
            Faculty.printArray();
            Cafedra cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            String group = DataInput.getString("Enter group a new student: ");
            int course = DataInput.getInt("Enter course of a new student: ");
            Student newStudent = new Student( cafedra,name,surname,FatherName, course, group);
            System.out.println(newStudent);
            studentArrayList.add(newStudent);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void editStudent() {
        try {
            Student toEdit = findStudent(DataInput.getString("Enter a name of an existing student: "));
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
    public static Student findStudent(String studentName) {
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            if (studentName.equalsIgnoreCase(student.getName())) {
                return student;
            }
        }
        return null;
    }
    public static void removeStudent(Student student){
        try {
            printArrayStudent();
            Student toDelete = findStudent(DataInput.getString("Enter a name of an existing student: "));
            studentArrayList.remove(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void printArrayStudent() {
        if(studentArrayList!=null) {
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            System.out.println(student);
        }}
        else {
            System.out.println("Students is empty");
        }
    }
    public static void createTeacher() {
        try {
            String name = DataInput.getString("Enter the name of the new student: ");
            String surname = DataInput.getString("Enter the surname of the new student: ");
            String FatherName = DataInput.getString("Enter the FatherName of the new student: ");

            Faculty.printArray();
            Cafedra cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));

            Teacher newStudent = new Teacher(cafedra,name,surname,FatherName);
            System.out.println(newStudent);
            teacherArrayList.add(newStudent);
            printArrayTeacher();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void editTeacher() {
        try {
            Teacher toEdit = findTeacher(DataInput.getString("Enter a name of an existing student: "));
            System.out.println(toEdit);
            if (DataInput.getChar("Do you want to change name? (y/a): ") == 'y')
                toEdit.setName(DataInput.getString("> "));
            if (DataInput.getChar("Do you want to change cafedra? (y/a): ") == 'y') {
                printArray();
                toEdit.setCafedra(findCafedra(DataInput.getString("Enter a name of an existing faculty: ")));
            }
            System.out.println(toEdit);
            printArrayTeacher();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static Teacher findTeacher(String teacherName) {
        for (int i = 0; i < teacherArrayList.size(); i++) {
            Teacher teacher = teacherArrayList.get(i);
            if (teacherName.equalsIgnoreCase(teacher.getName())) {
                return teacher;
            }
        }
        return null;
    }
    public static void removeTeacher(Teacher teacher){
        try {
            printArrayTeacher();
            Teacher toDelete = findTeacher(DataInput.getString("Enter a name of an existing student: "));
            teacherArrayList.remove(teacher);
            printArrayTeacher();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void printArrayTeacher() {
        if(teacherArrayList!=null) {
            for (int i = 0; i < teacherArrayList.size(); i++) {
                Teacher teacher = teacherArrayList.get(i);
                System.out.println(teacher);
            }
        }
        else{
            System.out.println("Teachers is empty");
        }
    }







}