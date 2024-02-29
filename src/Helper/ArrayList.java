package src.Helper;

import src.Model.Student;
import src.Model.Teacher;

import java.util.AbstractList;
import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        elements = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) elements[index];
    }
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
    public static void printStudentsOfCourseSorted(ArrayList studentArrayList, int course) {
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
                if(student.getCourse() == course) {
                    System.out.println(student.toString());
                }
            }
        }
    }

    public static void printStudentsByAlphabet(ArrayList studentArrayList) {
        {
            Student[] studentArray = new Student[studentArrayList.size()];
            for (int i = 0; i < studentArrayList.size(); i++) {
                studentArray[i] = (Student) studentArrayList.get(i);
            }

            for (int i = studentArray.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (studentArray[j].getSurname().compareTo( studentArray[j + 1].getSurname()) > 0) {
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
    public static void printTeachersByAlphabet(ArrayList studentArrayList) {
        {
            Teacher[] studentArray = new Teacher[studentArrayList.size()];
            for (int i = 0; i < studentArrayList.size(); i++) {
                studentArray[i] = (Teacher) studentArrayList.get(i);
            }

            for (int i = studentArray.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (studentArray[j].getSurname().compareTo( studentArray[j + 1].getSurname()) > 0) {
                        Teacher temp = studentArray[j];
                        studentArray[j] = studentArray[j + 1];
                        studentArray[j + 1] = temp;
                    }
                }
            }
            for (Teacher student : studentArray) {
                System.out.println(student.toString());
            }
        }
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
