package src.Model;

import lombok.Data;
import src.Interfaces.Person;
@Data
public class Student extends Person {
    private int course;
    private String group;
    public Student(Cafedra cafedra, String name, String surname, String fatherName,int course,String group) {
        super(cafedra, name, surname, fatherName);
        this.course = course;
        this.group = group;
    }
    public String toString() {
        return "Студент: " +
                "прізвище: " + getSurname() + ", " +
                "ім'я: " + getName() + ", " +
                "по-батькові: " + getFatherName() + ", "+
                "Факультет: " + getCafedra().getFaculty().getName() + "," +
                "кафедра: " + getCafedra().getName() +", " +
                "курс: " + course + ", "+
                "група: " + group;
    }

    public int getCourse() {
        return course;
    }


    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}