package src;

import src.Helper.*;
import src.Model.*;

import java.io.IOException;
import static src.Const.*;
import static src.Model.University.findFaculty;

public class Main {
    public static void main(String[] args) {
        University uni = new University();
        int option =-1;
        while (option != 0) {
            System.out.println(mainMenuText);
            option = DataInput.checkInt(DataInput.getInt("Choose an option: "), 0, 10);
            int choice;
            switch (option) {
                case 1 -> {
                    System.out.println("What exactly do you want to do with a faculty?");
                    System.out.println(changeMenu);
                    choice = DataInput.getInt("> ");
                    switch (choice) {
                        case 1 -> {
                            University.printArray();
                            uni.createFaculty();
                            University.printArray();
                        }
                        case 2 -> uni.editFaculty();
                        case 3 -> {
                            Faculty toDelete ;
                            try {
                                toDelete = findFaculty(DataInput.getString("Enter the name of a faculty you want to delete: "));
                                uni.removeFaculty(toDelete);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        default -> System.out.println("Exit");
                    }
                }
                case 2 -> {
                    System.out.println("What exactly do you want to do with a Cafedra?");
                    System.out.println(changeMenu);
                    choice = DataInput.getInt("> ");
                    switch (choice) {
                        case 1 -> {
                            University.printArray();
                            uni.createFaculty();
                            University.printArray();
                        }
                        case 2 -> uni.editFaculty();
                        case 3 -> {
                            Faculty toDelete = null;
                            try {
                                toDelete = findFaculty(DataInput.getString("Enter the name of a faculty you want to delete: "));
                                uni.removeFaculty(toDelete);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        default -> System.out.println("Exit");
                    }
                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
                case 7 -> {

                }
                case 8 -> {

                }
                case 9 -> {

                }
                case 10 -> {

                }
            }
        }
    }




}