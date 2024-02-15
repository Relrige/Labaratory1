package src.Model;

import lombok.Data;
import src.Interfaces.Person;

public class Teacher extends Person {

    public Teacher(int id, int cafedraId, String name, String surname, String fatherName) {
        super(id, cafedraId, name, surname, fatherName);
    }
}


