package src.Model;

import lombok.Data;
import src.Helper.ArrayList;

@Data
public class Cafedra {
    private String name;
    ArrayList<Student> studentArrayList;
    ArrayList<Teacher> techerArrayList;

    public Cafedra(String name) {
        this.name=name;
    }

    public void addStudent(Student student){
        studentArrayList.add(student);
    }
    public void removeStudent(Student student){
        studentArrayList.remove(student);
    }
    public void addTeacher(Teacher teacher){
        techerArrayList.add(teacher);
    }
    public void removeTeacher(Teacher teacher){
        techerArrayList.remove(teacher);
    }



}