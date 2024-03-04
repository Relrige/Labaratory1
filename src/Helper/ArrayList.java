package src.Helper;

import src.Model.Student;
import src.Model.Teacher;

import java.util.AbstractList;
import java.util.Arrays;
/**
 * An implementation of the ArrayList data structure.
 *
 * @param <E> The type of elements in the ArrayList.
 */
public class ArrayList<E> extends AbstractList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    /**
     * Constructs an ArrayList with the specified capacity.
     *
     * @param capacity The initial capacity of the ArrayList.
     */
    public ArrayList(int capacity) {
        elements = new Object[capacity];
    }
    /**
     * Returns the number of elements in this list.
     *
     * @return The number of elements in this list.
     */
    public int size() {
        return size;
    }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index The index of the element to return.
     * @return The element at the specified position in this list.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) elements[index];
    }
    /**
     * Prints students sorted by course.
     *
     * @param studentArrayList The ArrayList of students.
     */
    public static void printStudentsByCourse(ArrayList studentArrayList) {
        {
            Student[] studentArray = new Student[studentArrayList.size()];
            for (int i = 0; i < studentArrayList.size(); i++) {
                studentArray[i] = (Student) studentArrayList.get(i);
            }

            for (int i = studentArray.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (studentArray[j].getCourse() > studentArray[j + 1].getCourse()) {
                        Student temp = studentArray[j];
                        studentArray[j] = studentArray[j + 1];
                        studentArray[j + 1] = temp;
                    }
                }
            }
            for (Student student : studentArray) {
                System.out.println(student.toString());
            }
        }
    }
    /**
     * Prints students of a specific course.
     *
     * @param studentArrayList The ArrayList of students.
     * @param course           The course to filter students by.
     */
    public static void printStudentsOfCourse(ArrayList studentArrayList, int course) {
        {
            Student[] studentArray = new Student[studentArrayList.size()];
            for (int i = 0; i < studentArrayList.size(); i++) {
                studentArray[i] = (Student) studentArrayList.get(i);
            }
            for (Student student : studentArray) {
                if(student.getCourse() == course) {
                    System.out.println(student.toString());
                }
            }
        }
    }
    /**
     * Prints students of a specific course sorted alphabetically.
     *
     * @param studentArrayList The ArrayList of students.
     * @param course           The course to filter students by.
     */
    public static void printStudentsOfCourseSorted(ArrayList studentArrayList, int course) {
        {
            Student[] studentArray = new Student[studentArrayList.size()];
            for (int i = 0; i < studentArrayList.size(); i++) {
                studentArray[i] = (Student) studentArrayList.get(i);
            }
            for (int i = studentArray.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (studentArray[j].getSurname().charAt(0) != 'і' && studentArray[j].getSurname().charAt(0) != 'ї' && studentArray[j].getSurname().charAt(0) != 'є') {
                        if (studentArray[j].getSurname().compareTo(studentArray[j + 1].getSurname()) > 0) {
                            Student temp = studentArray[j];
                            studentArray[j] = studentArray[j + 1];
                            studentArray[j + 1] = temp;
                        }
                    } else {
                        char temp = studentArray[j].getSurname().charAt(0);
                        if (temp == 'і') {
                            temp = 'и';
                        }
                        if (temp == 'ї') {
                            temp = 'й';
                        }
                        if (temp == 'є') {
                            temp = 'е';
                        }
                        if (temp > studentArray[j + 1].getSurname().charAt(0)) {
                            Student temp1 = studentArray[j];
                            studentArray[j] = studentArray[j + 1];
                            studentArray[j + 1] = temp1;
                        }
                        else if (studentArray[j + 1].getSurname().charAt(0) == studentArray[j + 1].getSurname().charAt(0) && studentArray[j].getSurname().compareTo(studentArray[j + 1].getSurname()) > 0) {
                            Student temp2 = studentArray[j];
                            studentArray[j] = studentArray[j + 1];
                            studentArray[j + 1] = temp2;
                        }

                    }
                }
            }
            for (Student student : studentArray) {
                if(student.getCourse() == course) {
                    System.out.println(student.toString());
                }
            }
        }
    }
    /**
     * Prints students of a specific course sorted alphabetically.
     *
     * @param studentArrayList The ArrayList of students.
     */
    public static void printStudentsByAlphabet(ArrayList<Student> studentArrayList) {
        {
            Student[] studentArray = new Student[studentArrayList.size()];
            for (int i = 0; i < studentArrayList.size(); i++) {
                studentArray[i] = (Student) studentArrayList.get(i);
            }

            for (int i = studentArray.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (studentArray[j].getSurname().charAt(0) != 'і' && studentArray[j].getSurname().charAt(0) != 'ї' && studentArray[j].getSurname().charAt(0) != 'є') {
                        if (studentArray[j].getSurname().compareTo(studentArray[j + 1].getSurname()) > 0) {
                            Student temp = studentArray[j];
                            studentArray[j] = studentArray[j + 1];
                            studentArray[j + 1] = temp;
                        }
                    } else {
                        char temp = studentArray[j].getSurname().charAt(0);
                        if (temp == 'і') {
                            temp = 'и';
                        }
                        if (temp == 'ї') {
                            temp = 'й';
                        }
                        if (temp == 'є') {
                            temp = 'е';
                        }
                        if (temp > studentArray[j + 1].getSurname().charAt(0)) {
                            Student temp1 = studentArray[j];
                            studentArray[j] = studentArray[j + 1];
                            studentArray[j + 1] = temp1;
                        }
                        else if (studentArray[j + 1].getSurname().charAt(0) == studentArray[j + 1].getSurname().charAt(0) && studentArray[j].getSurname().compareTo(studentArray[j + 1].getSurname()) > 0) {
                            Student temp2 = studentArray[j];
                            studentArray[j] = studentArray[j + 1];
                            studentArray[j + 1] = temp2;
                        }


                    }
                }
            }
            for (Student student : studentArray) {
                System.out.println(student.toString());
            }
        }
    }
    /**
     * Prints teachers of a specific course sorted alphabetically.
     *
     * @param studentArrayList The ArrayList of students.
     */
    public static void printTeachersByAlphabet(ArrayList<Teacher> studentArrayList) {
        {
            Teacher[] studentArray = new Teacher[studentArrayList.size()];
            for (int i = 0; i < studentArrayList.size(); i++) {
                studentArray[i] = (Teacher) studentArrayList.get(i);
            }

            for (int i = studentArray.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (studentArray[j].getSurname().charAt(0) != 'і' && studentArray[j].getSurname().charAt(0) != 'ї' && studentArray[j].getSurname().charAt(0) != 'є') {
                        if (studentArray[j].getSurname().compareTo(studentArray[j + 1].getSurname()) > 0) {
                            Teacher temp = studentArray[j];
                            studentArray[j] = studentArray[j + 1];
                            studentArray[j + 1] = temp;
                        }
                    }
                    else {
                        char temp = studentArray[j].getSurname().charAt(0);
                        if (temp == 'і') {
                            temp = 'и';
                        }
                        if (temp == 'ї') {
                            temp = 'й';
                        }
                        if (temp == 'є') {
                            temp = 'е';
                        }
                        if(temp > studentArray[j + 1].getSurname().charAt(0)){
                            Teacher temp1 = studentArray[j];
                            studentArray[j] = studentArray[j + 1];
                            studentArray[j + 1] = temp1;
                        } else if (studentArray[j + 1].getSurname().charAt(0) == studentArray[j + 1].getSurname().charAt(0) && studentArray[j].getSurname().compareTo(studentArray[j + 1].getSurname()) > 0) {
                            Teacher temp2 = studentArray[j];
                            studentArray[j] = studentArray[j + 1];
                            studentArray[j + 1] = temp2;
                        }


                    }
                }
            }
            for (Teacher student : studentArray) {
                System.out.println(student.toString());
            }
        }
    }
    public E[] sort(ArrayList<E> arrayList){
        E[] array = (E[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = arrayList.get(i);
        }
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(((Comparable)array[i]).compareTo(array[j])>0){
                    E temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        Object item = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (E) item;
    }
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

}
