package src.Model;

import lombok.Data;
import src.Interfaces.Person;

/**
 * Represents a teacher entity in the system.
 */
public class Teacher extends Person {

    /**
     * Constructs a new Teacher object.
     *
     * @param cafedra   The department to which the teacher belongs.
     * @param name      The name of the teacher.
     * @param surname   The surname of the teacher.
     * @param fatherName The father's name of the teacher.
     */
    public Teacher(Cafedra cafedra, String name, String surname, String fatherName) {
        super(cafedra, name, surname, fatherName);
    }

    /**
     * Returns a string representation of the teacher.
     *
     * @return A string representation of the teacher.
     */
    @Override
    public String toString() {
        return "Викладач: " +
                "прізвище: " + getSurname() + ", " +
                "ім'я: " + getName() + ", " +
                "по-батькові: " + getFatherName() + ", " +
                "Факультет: " + getCafedra().getFaculty().getName() + ", " +
                "кафедра: " + getCafedra().getName();
    }
}




