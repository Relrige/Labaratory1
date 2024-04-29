package src.Model;

import lombok.Data;
import src.Helper.*;

import java.io.IOException;
import java.util.Objects;

import static src.Model.Faculty.findCafedra;
import static src.Model.Faculty.printArray;
/**
 * Represents a department (Cafedra) within a faculty.
 */
@Data
public class Cafedra {
    private final Faculty faculty;
    private String name;
    ArrayList<Student> studentArrayList;
    ArrayList<Teacher> teacherArrayList;
    public Cafedra(Faculty faculty) {
        this.faculty = faculty;
        studentArrayList=new ArrayList<>();
        teacherArrayList=new ArrayList<>();
    }
    public Cafedra(String name, Faculty faculty) {
        this.name=name;
        this.faculty=faculty;
        studentArrayList=new ArrayList<>();
        teacherArrayList=new ArrayList<>();
    }
    public static boolean containsDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    public static void teacherSeeder(){
        Cafedra cafedra=findCafedra("Cafedra of informatics");
        Teacher newTeacher=new Teacher(findCafedra("Cafedra of informatics"),"Владислав","Швець","Олександрович");
        University.uniTeacherArrayList.add(newTeacher);
        cafedra.getTeacherArrayList().add(newTeacher);
        cafedra.getFaculty().getFacultyTeacherArrayList().add(newTeacher);

        newTeacher = new Teacher(cafedra, "Олександр", "Петров", "Сергійович");
        University.uniTeacherArrayList.add(newTeacher);
        cafedra.getTeacherArrayList().add(newTeacher);
        cafedra.getFaculty().getFacultyTeacherArrayList().add(newTeacher);

        newTeacher = new Teacher(cafedra, "Наталія", "Іванова", "Василівна");
        University.uniTeacherArrayList.add(newTeacher);
        cafedra.getTeacherArrayList().add(newTeacher);
        cafedra.getFaculty().getFacultyTeacherArrayList().add(newTeacher);
        cafedra=findCafedra("Cafedra multimedia");
        newTeacher = new Teacher(cafedra, "Ігор", "Сидоренко", "Петрович");
        University.uniTeacherArrayList.add(newTeacher);
        cafedra.getTeacherArrayList().add(newTeacher);
        cafedra.getFaculty().getFacultyTeacherArrayList().add(newTeacher);

        newTeacher = new Teacher(cafedra, "Олена", "Михайленко", "Іванівна");
        University.uniTeacherArrayList.add(newTeacher);
        cafedra.getTeacherArrayList().add(newTeacher);
        cafedra.getFaculty().getFacultyTeacherArrayList().add(newTeacher);

        newTeacher = new Teacher(cafedra, "Максим", "Коваленко", "Олександрович");
        University.uniTeacherArrayList.add(newTeacher);
        cafedra.getTeacherArrayList().add(newTeacher);
        cafedra.getFaculty().getFacultyTeacherArrayList().add(newTeacher);
        cafedra=findCafedra("Cafedra politologii");
        newTeacher = new Teacher(cafedra, "Тетяна", "Сергієнко", "Миколаївна");
        University.uniTeacherArrayList.add(newTeacher);
        cafedra.getTeacherArrayList().add(newTeacher);
        cafedra.getFaculty().getFacultyTeacherArrayList().add(newTeacher);

        newTeacher = new Teacher(cafedra, "Андрій", "Григоренко", "Анатолійович");
        University.uniTeacherArrayList.add(newTeacher);
        cafedra.getTeacherArrayList().add(newTeacher);
        cafedra.getFaculty().getFacultyTeacherArrayList().add(newTeacher);
    }
    public static void studentSeeder(){
        Cafedra cafedra=findCafedra("Cafedra of informatics");
        Student newStudent=new Student(findCafedra("Cafedra of informatics"),"Владислав","Швець","Олександрович",1,"Група1");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Іван", "Петренко", "Олександрович", 2, "Група1");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Марія", "Іваненко", "Олексіївна", 3, "Група1");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Анна", "Михайленко", "Петрівна", 1, "Група1");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Олексій", "Коваленко", "Миколайович", 2, "Група2");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Юлія", "Сергієнко", "Валеріївна", 3, "Група2");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        Student student8 = new Student(cafedra, "Наталія", "Павленко", "Михайлівна", 2, "Група2");
        University.uniStudentArrayList.add(student8);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        cafedra = findCafedra("Cafedra multimedia");
        newStudent = new Student(cafedra, "Ігор", "Бондаренко", "Олександрович", 3, "Група3");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Юлія", "Сидоренко", "Анатоліївна", 2, "Група3");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        Student student14 = new Student(cafedra, "Наталія", "Кравченко", "Миколаївна", 4, "Група3");
        University.uniStudentArrayList.add(student14);
        cafedra.getStudentArrayList().add(student14);
        cafedra.getFaculty().getFacultyStudentArrayList().add(student14);

        newStudent = new Student(cafedra, "Віталій", "Соколов", "Олексійович", 1, "Група3");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Оксана", "Козлова", "Василівна", 2, "Група3");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Микола", "Мельник", "Андрійович", 2, "Група4");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Олена", "Полякова", "Сергіївна", 1, "Група4");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        cafedra=findCafedra("Cafedra politologii");

        newStudent = new Student(cafedra, "Вікторія", "Павлюченко", "Михайлівна", 4, "Група4");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Сергій", "Коваль", "Олександрович", 1, "Група4");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Олег", "Мороз", "Олексійович", 1, "Група5");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Катерина", "Козачук", "Анатоліївна", 2, "Група5");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Ірина", "Романенко", "Андріївна", 1, "Група5");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Олександр", "Шевченко", "Вікторович", 2, "Група5");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);

        newStudent = new Student(cafedra, "Наталія", "Поліщук", "Василівна", 4, "Група5");
        University.uniStudentArrayList.add(newStudent);
        cafedra.getStudentArrayList().add(newStudent);
        cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);
    }
    /**
     * Creates a new student and adds it to the system.
     * Prompts the user for necessary information such as name, surname, father's name, department, group, and course.
     * Once the student is created, it is added to the appropriate lists.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void createStudent() {
        try {
            String surname;
            do {
                surname = DataInput.getString("Enter the surname of the new student: ");
                if (containsDigit(surname)) {
                    System.out.println("Surname should not contain digits. Please enter a valid surname.");
                }
            } while (containsDigit(surname));
            String name;
            do {
                name = DataInput.getString("Enter the name of the new student: ");
                if (containsDigit(name)) {
                    System.out.println("Name should not contain digits. Please enter a valid name.");
                }
            } while (containsDigit(name));

            String fatherName;
            do {
                fatherName = DataInput.getString("Enter the father's name of the new student: ");
                if (containsDigit(fatherName)) {
                    System.out.println("Father's name should not contain digits. Please enter a valid father's name.");
                }
            } while (containsDigit(fatherName));
            printArray();
            Cafedra cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            while (cafedra==null) {
                System.out.println("Enter a valid value for cafedra");
                cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            }
            String group = DataInput.getString("Enter group a new student: ");
            int course = DataInput.getInt("Enter course of a new student: ");
            while (course <= 0 || course > 6) {
                System.out.println("Enter a valid value for course (1-6)");
                course = DataInput.getInt("Enter course of a new student: ");
            }
            Student newStudent = new Student( cafedra,name,surname,fatherName, course, group);
            System.out.println(newStudent);
            University.uniStudentArrayList.add(newStudent);
            cafedra.getStudentArrayList().add(newStudent);
            cafedra.getFaculty().getFacultyStudentArrayList().add(newStudent);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Edits the details of an existing student.
     * Prompts the user for the student's name, surname, and father's name to find the student.
     * Then, provides options to edit the student's name, department, year of study, and group.
     * Prints the updated student details after editing.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void editStudent() {
        try {
            Student toEdit = findStudent(DataInput.getString("Enter a name of an existing student: "),
                    DataInput.getString("Enter a surName of an existing student: "),
                    DataInput.getString("Enter a fatherName of an existing student: "));
            System.out.println(toEdit);
            if (DataInput.getChar("Do you want to change name? (y/a): ") == 'y')
                toEdit.setName(DataInput.getString("> "));
            if (DataInput.getChar("Do you want to change cafedra? (y/a): ") == 'y') {
                printArray();
                toEdit.setCafedra(findCafedra(DataInput.getString("Enter a name of an existing faculty: ")));
            }
            if (DataInput.getChar("Do you want to change year of studying? (y/a): ") == 'y')
                toEdit.setCourse(DataInput.checkInt(DataInput.getInt("> "), 0, 6));
            if (DataInput.getChar("Do you want to change group? (y/a): ") == 'y')
                toEdit.setGroup(DataInput.getString("> "));
            System.out.println(toEdit);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Finds a student based on their course.
     *
     * @param course The course of the student to find.
     * @return The student object if found, otherwise null.
     */
    public static void findStudent(int course) {
        int counter=0;
        for (int i = 0; i < University.uniStudentArrayList.size(); i++) {
            Student student = University.uniStudentArrayList.get(i);
            if (course==student.getCourse()) {
                System.out.println(student);
                counter++;
            }
        }
        if(counter==0)
            System.out.println("No students found");
    }    /**
     * Finds a student based on their course.
     *
     * @param group The group of the student to find.
     * @return The student object if found, otherwise null.
     */
    public static void findStudent(String group) {
        int counter=0;
        for (int i = 0; i < University.uniStudentArrayList.size(); i++) {
            Student student = University.uniStudentArrayList.get(i);
            if (Objects.equals(group, student.getGroup())) {
                System.out.println(student);
                counter++;
            }
        }
        if(counter==0)
            System.out.println("No students found");
    }
    /**
     * Finds a student based on their name, surname, and father's name.
     *
     * @param studentName The name of the student to find.
     * @param surName     The surname of the student to find.
     * @param fatherName  The father's name of the student to find.
     * @return The student object if found, otherwise null.
     */
    public static Student findStudent(String studentName,String surName,String fatherName) {
        for (int i = 0; i < University.uniStudentArrayList.size(); i++) {
            Student student = University.uniStudentArrayList.get(i);
            if (studentName.equalsIgnoreCase(student.getName())&&surName.equalsIgnoreCase(student.getSurname())&&fatherName.equalsIgnoreCase(student.getFatherName())) {
                return student;
            }
        }

        System.out.println("No students found");
        return null;
    }
    /**
     * Removes the specified student from all relevant lists.
     * This method removes the student from the student list of their cafedra,
     * removes them from the student list of their faculty,
     * and removes them from the university-wide student list.
     *
     * @param student The student to be removed.
     */
    public static void removeStudent(Student student){
        student.getCafedra().getStudentArrayList().remove(student);
        student.getCafedra().getFaculty().getFacultyStudentArrayList().remove(student);
        University.uniStudentArrayList.remove(student);
    }
    /**
     * Creates a new teacher and adds them to the system.
     * Prompts the user for necessary information such as name, surname, father's name, and department.
     * Once the teacher is created, they are added to the appropriate lists.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void createTeacher() {
        try {
            String surname;
            do {
                surname = DataInput.getString("Enter the surname of the new student: ");
                if (containsDigit(surname)) {
                    System.out.println("Surname should not contain digits. Please enter a valid surname.");
                }
            } while (containsDigit(surname));
            String name;
            do {
                name = DataInput.getString("Enter the name of the new student: ");
                if (containsDigit(name)) {
                    System.out.println("Name should not contain digits. Please enter a valid name.");
                }
            } while (containsDigit(name));
            String fatherName;
            do {
                fatherName = DataInput.getString("Enter the father's name of the new student: ");
                if (containsDigit(fatherName)) {
                    System.out.println("Father's name should not contain digits. Please enter a valid father's name.");
                }
            } while (containsDigit(fatherName));
            printArray();
            Cafedra cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            while (cafedra==null) {
                System.out.println("Enter a valid value for cafedra");
                cafedra = findCafedra(DataInput.getString("Enter a name of an existing cafedra: "));
            }
            Teacher newStudent = new Teacher(cafedra,name,surname,fatherName);
            System.out.println(newStudent);
            cafedra.getTeacherArrayList().add(newStudent);
            cafedra.getFaculty().getFacultyTeacherArrayList().add(newStudent);
            University.uniTeacherArrayList.add(newStudent);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Edits the details of an existing teacher.
     * Prompts the user for the teacher's name, surname, and father's name to find the teacher.
     * Then, provides options to edit the teacher's name, department.
     * Prints the updated teacher details after editing.
     * If any errors occur during the process, they are caught and printed.
     */
    public static void editTeacher() {
        try {
            Teacher toEdit = findTeacher(DataInput.getString("Enter a name of an existing teacher: "),
                    DataInput.getString("Enter a surName of an existing teacher: "),
                    DataInput.getString("Enter a fatherName of an existing teacher: "));
            if(toEdit==null){
                System.out.println("Teacher not found");
                return;
            }
            System.out.println(toEdit);
            if (DataInput.getChar("Do you want to change name? (y/a): ") == 'y')
                toEdit.setName(DataInput.getString("> "));
            if (DataInput.getChar("Do you want to change cafedra? (y/a): ") == 'y') {
                printArray();
                toEdit.setCafedra(findCafedra(DataInput.getString("Enter a name of an existing faculty: ")));
            }
            System.out.println(toEdit);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Finds a teacher based on their name, surname, and father's name.
     *
     * @param studentName The name of the teacher to find.
     * @param surName     The surname of the teacher to find.
     * @param fatherName  The father's name of the teacher to find.
     * @return The teacher object if found, otherwise null.
     */
    public static Teacher findTeacher(String studentName,String surName,String fatherName) {
        for (int i = 0; i < University.uniTeacherArrayList.size(); i++) {
            Teacher teacher = University.uniTeacherArrayList.get(i);
            if (studentName.equalsIgnoreCase(teacher.getName())&&surName.equalsIgnoreCase(teacher.getSurname())&&fatherName.equalsIgnoreCase(teacher.getFatherName())) {
                return teacher;
            }
        }
        System.out.println("No teachers found");
        return null;
    }
    /**
     * Removes the specified teacher from all relevant lists.
     * This method removes the teacher from the teacher list of their cafedra,
     * removes them from the teacher list of their faculty,
     * and removes them from the university-wide teacher list.
     *
     * @param teacher The teacher to be removed.
     */
    public static void removeTeacher(Teacher teacher){
        teacher.getCafedra().getTeacherArrayList().remove(teacher);
        teacher.getCafedra().getFaculty().getFacultyTeacherArrayList().remove(teacher);
        University.uniTeacherArrayList.remove(teacher);

    }

    public String toString(){
        return "Cafedra of the " + faculty +" faculty: "+name;
    }

    public ArrayList getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public ArrayList getTeacherArrayList() {
        return teacherArrayList;
    }

    public void setTeacherArrayList(ArrayList teacherArrayList) {
        this.teacherArrayList = teacherArrayList;
    }
}
