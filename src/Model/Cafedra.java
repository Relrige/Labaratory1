package src.Model;

import lombok.Data;
import src.Helper.ArrayList;

@Data
public class Cafedra {
    private String name;
    ArrayList<Faculty> facultyArrayList;

}