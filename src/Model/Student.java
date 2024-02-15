package src.Model;

import lombok.Data;
import src.Interfaces.Person;
@Data
public class Student extends Person {
    private String course;
    private String group;
    public Student(int id, int cafedraId, String name, String surname, String fatherName,String course,String group) {
        super(id, cafedraId, name, surname, fatherName);
        this.course = course;
        this.group = group;
    }
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}