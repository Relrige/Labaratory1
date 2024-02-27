package src.Model;

import lombok.Data;
import src.Helper.ArrayList;
import src.Helper.DataInput;

import static src.Model.University.findFaculty;

@Data
public class Faculty {
    private String name;
    public static ArrayList<Cafedra> cafedraArrayList;
    public Faculty(){
        cafedraArrayList=new ArrayList<>();
    }
    public Faculty(String name) {
        cafedraArrayList=new ArrayList<>();
        this.name=name;
    }
    public static void createCafedra() {
        try {
            String name = DataInput.getString("Enter the name of the new cafedra: ");
            Faculty faculty = findFaculty(DataInput.getString("Enter a name of an existing faculty: "));
            Cafedra newCafedra = new Cafedra(name);
            cafedraArrayList.add(newCafedra);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void editCafedra() {
        try {
            Cafedra toEdit = findCafedra(DataInput.getString("Enter the name of a cafedra you want to change: "));
            toEdit.setName(DataInput.getString("Enter a new name for a cafedra: "));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static Cafedra findCafedra(String cafedraName) {
        for (int i = 0; i < cafedraArrayList.size(); i++) {
            Cafedra cafedra = cafedraArrayList.get(i);
            if (cafedraName.equalsIgnoreCase(cafedra.getName())) {
                return cafedra;
            }
        }
        return null;
    }
    public static void removeCafedra(Cafedra cafedra){
        cafedraArrayList.remove(cafedra);
    }

    public static void printArray() {
        if(cafedraArrayList!=null) {
            for (int i = 0; i < cafedraArrayList.size(); i++) {
                Cafedra cafedra = cafedraArrayList.get(i);
                System.out.println(cafedra);
            }
        }else
        {
            System.out.println("Empty cafedra arrayList");
        }
    }

}