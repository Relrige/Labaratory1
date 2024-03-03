package src.Model;

import lombok.Data;
import src.Interfaces.Person;

/**
 * Represents a student entity in the system.
 */
@Data
public class Student extends Person {
    private int course; // The course of the student
    private String group; // The group of the student

    /**
     * Constructs a new Student object.
     *
     * @param cafedra   The department to which the student belongs.
     * @param name      The name of the student.
     * @param surname   The surname of the student.
     * @param fatherName The father's name of the student.
     * @param course    The course of the student.
     * @param group     The group of the student.
     */
    public Student(Cafedra cafedra, String name, String surname, String fatherName, int course, String group) {
        super(cafedra, name, surname, fatherName);
        this.course = course;
        this.group = group;
    }

    /**
     * Returns a string representation of the student.
     *
     * @return A string representation of the student.
     */
    @Override
    public String toString() {
        return "Студент: " +
                "прізвище: " + getSurname() + ", " +
                "ім'я: " + getName() + ", " +
                "по-батькові: " + getFatherName() + ", " +
                "Факультет: " + getCafedra().getFaculty().getName() + ", " +
                "кафедра: " + getCafedra().getName() + ", " +
                "курс: " + course + ", " +
                "група: " + group;
    }


}
