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
        uniStudentArrayList = new ArrayList<>();
        uniTeacherArrayList = new ArrayList<>();
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
                            try {
                                toDelete = findCafedra(DataInput.getString("Enter the name of a faculty you want to delete: "));
                                Faculty.removeCafedra(toDelete);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
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
                                try {
                                    toDelete = findStudent(DataInput.getString("Enter the name of a faculty you want to delete: "));
                                    Cafedra.removeStudent(toDelete);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
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
                                try {
                                    toDelete = findTeacher(DataInput.getString("Enter the name of a faculty: "));
                                    Cafedra.removeTeacher(toDelete);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            default -> System.out.println("Exit");
                        }
                    }
                }
                case 4 -> {


                }
                case 5 -> {
                    ArrayList.printStudentsByCourse(uniStudentArrayList);

                }
                case 6 -> {
                    int choice2 = DataInput.getInt("For student enter 1 / for teacher enter 2?");
                    while (choice2 != 1 && choice2 != 2) {
                        System.out.println("Invalid input. Please try again.");
                        choice2 = DataInput.getInt("For student enter 1 / for teacher enter 2?");
                    }

                    Faculty faculty = null;
                    try {
                        faculty = findFaculty(DataInput.getString("Enter the name of a faculty: "));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    if (choice2 == 1) {
                        ArrayList.printStudentsByAlphabet(faculty.getFacultyStudentArrayList());
                    } else if (choice2 == 2) {
                        ArrayList.printTeachersByAlphabet(faculty.getFacultyTeacherArrayList());
                    }

                }
                case 7 -> {
                    Cafedra cafedra = null;

                    try {
                        cafedra = findCafedra(DataInput.getString("Enter the name of a cafedra: "));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ArrayList.printStudentsByCourse(cafedra.getStudentArrayList());

                }

                case 8 -> {
                    int choice2 = DataInput.getInt("For student enter 1 / for teacher enter 2?");
                    while (choice2 != 1 && choice2 != 2) {
                        System.out.println("Invalid input. Please try again.");
                        choice2 = DataInput.getInt("For student enter 1 / for teacher enter 2?");
                    }

                    Cafedra cafedra = null;
                    try {
                        cafedra = findCafedra(DataInput.getString("Enter the name of a cafedra: "));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    if (choice2 == 1) {
                        ArrayList.printStudentsByAlphabet(cafedra.getStudentArrayList());
                    } else if (choice2 == 2) {
                        ArrayList.printTeachersByAlphabet(cafedra.getTeacherArrayList());
                    }



                }
                case 9 -> {
                    Cafedra cafedra = null;
                    int course = DataInput.getInt("Enter the course: ");
                    try {
                        cafedra = findCafedra(DataInput.getString("Enter the name of a cafedra: "));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ArrayList.printStudentsOfCourse(cafedra.getStudentArrayList(), course);

                }

                case 10 -> {
                    Cafedra cafedra = null;
                    int course = DataInput.getInt("Enter the course: ");
                    try {
                        cafedra = findCafedra(DataInput.getString("Enter the name of a cafedra: "));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ArrayList.printStudentsOfCourseSorted(cafedra.getStudentArrayList(), course);
                }
            }
        }
    }
}


}