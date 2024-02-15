package src.Model;

import lombok.Data;
import src.Helper.ArrayList;

@Data
public class University {
    ArrayList<Cafedra> cafedraArrayList;
    String name = "TNU";
    public void addCafedra(Cafedra cafedra){
        cafedraArrayList.add(cafedra);
    }
    public void removeCafedra(Cafedra cafedra){
        cafedraArrayList.remove(cafedra);
    }
}
