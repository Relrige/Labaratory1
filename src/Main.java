package src;

import src.Helper.*;
import src.Model.*;

import java.io.IOException;
import static src.Const.*;
import static src.Model.Cafedra.*;
import static src.Model.Faculty.findCafedra;
import static src.Model.University.findFaculty;

public class Main {
    public static void main(String[] args) {
        University uni = new University();
        uni.uniStudentArrayList = new ArrayList<>();
        uni.uniTeacherArrayList = new ArrayList<>();
        int option = -1;
        while (option != 0) {
            System.out.println(Const.mainMenuText);
            option = DataInput.checkInt(DataInput.getInt("Choose an option: "), 0, 10);
            int choice;
            switch (option) {
                case 1 -> {
                    System.out.println("What exactly do you want to do with a faculty?");
                    System.out.println(Const.changeMenu);
                    choice = DataInput.getInt("> ");
                    switch (choice) {
                        case 1 -> {
                            University.printArray();
                            uni.createFaculty();
                            University.printArray();
                        }
                        case 2 -> uni.editFaculty();
                        case 3 -> {
                            Faculty toDelete;
                            toDelete = findFaculty(DataInput.getString("Enter the name of a faculty you want to delete: "));
                            uni.removeFaculty(toDelete);
                        }
                        default -> System.out.println("Exit");
                    }
                }
                case 2 -> {
                    System.out.println("What exactly do you want to do with a Cafedra?");
                    System.out.println(Const.changeMenu);
                    choice = DataInput.getInt("> ");
                    switch (choice) {
                        case 1 -> {
                            Faculty.printArray();
                            Faculty.createCafedra();
                            Faculty.printArray();
                        }
                        case 2 -> Faculty.editCafedra();
                        case 3 -> {
                            Cafedra toDelete;
                            toDelete = findCafedra(DataInput.getString("Enter the name of a cafedra you want to delete: "));
                            Faculty.removeCafedra(toDelete);
                        }
                        default -> System.out.println("Exit");
                    }
                }
                case 3 -> {
                    int choice2 = DataInput.getInt("For student enter 1 / for teacher enter 2?");
                    if (choice2 == 1) {
                        System.out.println("What exactly do you want to do with a Student?");
                        System.out.println(Const.changeMenu);
                        choice = DataInput.getInt("> ");
                        switch (choice) {
                            case 1 -> {
                                Cafedra.createStudent();
                            }
                            case 2 -> Cafedra.editStudent();
                            case 3 -> {
                                Student toDelete;
                                toDelete = findStudent(DataInput.getString("Enter a name of an existing student: "),
                                        DataInput.getString("Enter a surName of an existing student: "),
                                        DataInput.getString("Enter a fatherName of an existing student: "));
                                if(toDelete!=null)
                                {
                                    Cafedra.removeStudent(toDelete);
                                }else{
                                    System.out.println("Student not found");
                                }
                            }
                            default -> System.out.println("Exit");
                        }
                    } else if (choice2 == 2) {
                        System.out.println("What exactly do you want to do with a Teacher?");
                        System.out.println(Const.changeMenu);
                        choice = DataInput.getInt("> ");
                        switch (choice) {
                            case 1 -> {
                                Cafedra.createTeacher();
                            }
                            case 2 -> Cafedra.editTeacher();
                            case 3 -> {
                                Teacher toDelete;
                                toDelete = findTeacher(DataInput.getString("Enter a name of an existing teacher: "),
                                        DataInput.getString("Enter a surName of an existing teacher: "),
                                        DataInput.getString("Enter a fatherName of an existing teacher: "));
                                if (toDelete != null) {
                                    Cafedra.removeTeacher(toDelete);
                                } else {
                                    System.out.println("Teacher not found");
                                }
                            }
                            default -> System.out.println("Exit");
                        }
                    }
                }
                case 4 -> {
                    int choice2 = DataInput.checkInt(DataInput.getInt("Enter 1 for student / 2 for teacher "),0 ,2);
                    if(choice2==1){

                        try {

                            System.out.println(findStudent(DataInput.getString("Enter a name of an existing student: "),
                                    DataInput.getString("Enter a surName of an existing student: "),
                                    DataInput.getString("Enter a fatherName of an existing student: ")
                            ));

                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    }
                    else if(choice2==2){
                        try {
                            System.out.println(findTeacher(DataInput.getString("Enter a name of an existing teacher: "),
                                    DataInput.getString("Enter a surName of an existing teacher: "),
                                    DataInput.getString("Enter a fatherName of an existing teacher: ")
                            ));
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    }
                }
                case 5 -> {
                    ArrayList.printStudentsByCourse(uni.uniStudentArrayList);

                }
                case 6 -> {
                    int choice2 = DataInput.getInt("For student enter 1 / for teacher enter 2?");
                    while (choice2 != 1 && choice2 != 2) {
                        System.out.println("Invalid input. Please try again.");
                        choice2 = DataInput.getInt("For student enter 1 / for teacher enter 2?");
                    }

                    Faculty faculty = null;
                    faculty = findFaculty(DataInput.getString("Enter the name of a faculty: "));
                    if(faculty!=null) {
                        if (choice2 == 1) {
                            ArrayList.printStudentsByAlphabet(faculty.getFacultyStudentArrayList());
                        }  if (choice2 == 2) {
                            ArrayList.printTeachersByAlphabet(faculty.getFacultyTeacherArrayList());
                        }
                    }else{
                        System.out.println("Faculty not found");
                    }

                }
                case 7 -> {
                    Cafedra cafedra = null;

                    cafedra = findCafedra(DataInput.getString("Enter the name of a cafedra: "));
                    if (cafedra!=null) {
                        ArrayList.printStudentsByCourse(cafedra.getStudentArrayList());
                    } else {
                        System.out.println("Cafedra not found");

                    }

                }

                case 8 -> {
                    int choice2 = DataInput.getInt("For student enter 1 / for teacher enter 2?");
                    while (choice2 != 1 && choice2 != 2) {
                        System.out.println("Invalid input. Please try again.");
                        choice2 = DataInput.getInt("For student enter 1 / for teacher enter 2?");
                    }

                    Cafedra cafedra = null;
                    cafedra = findCafedra(DataInput.getString("Enter the name of a cafedra: "));
                    if(cafedra!=null){
                        if (choice2 == 1) {
                            ArrayList.printStudentsByAlphabet(cafedra.getStudentArrayList());
                        }  if (choice2 == 2){
                            ArrayList.printTeachersByAlphabet(cafedra.getTeacherArrayList());
                        }
                    }else{
                        System.out.println("Cafedra not found");
                    }




                }
                case 9 -> {
                    Cafedra cafedra = null;
                    int course = DataInput.getInt("Enter the course: ");
                    cafedra = findCafedra(DataInput.getString("Enter the name of a cafedra: "));
                    if(cafedra!=null) {
                        ArrayList.printStudentsOfCourse(cafedra.getStudentArrayList(), course);
                    }else{
                        System.out.println("Cafedra not found");
                    }

                }

                case 10 -> {
                    Cafedra cafedra = null;
                    int course = DataInput.getInt("Enter the course: ");
                    cafedra = findCafedra(DataInput.getString("Enter the name of a cafedra: "));
                    if (cafedra != null) {
                        ArrayList.printStudentsOfCourseSorted(cafedra.getStudentArrayList(), course);
                    } else {
                        System.out.println("Cafedra not found");
                    }
                }
            }
        }
    }
}



