package src.Model;

import lombok.Data;
import src.Interfaces.Person;

public class Teacher extends Person {

    public Teacher(Cafedra cafedra, String name, String surname, String fatherName) {
        super(cafedra, name, surname, fatherName);
    }
}


