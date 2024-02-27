package src.Model;

import lombok.Data;
import src.Helper.ArrayList;
import src.Helper.DataInput;

import static src.Model.University.findFaculty;

@Data
public class Faculty {
    private String name;
    public static ArrayList<Cafedra> cafedraArrayList;

    public Faculty(String name) {
        this.name=name;
    }
    private static void createDepartment() {
        try {
            String name = DataInput.getString("Enter the name of the new department: ");
            Faculty faculty = findFaculty(DataInput.getString("Enter a name of an existing faculty: "));
            Cafedra newCafedra = new Cafedra(name);
            cafedraArrayList.add(newCafedra);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void removeCafedra(Cafedra cafedra){
        cafedraArrayList.remove(cafedra);
    }


}