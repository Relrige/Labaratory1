package src.Model;

import lombok.Data;
import src.Helper.ArrayList;

@Data
public class Faculty {
    private String name;
    ArrayList<Cafedra> studentArrayList;

}