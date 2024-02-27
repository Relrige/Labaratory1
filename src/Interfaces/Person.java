package src.Interfaces;

import src.Model.Cafedra;

public class Person {
    private Cafedra cafedra;
    private String name;
    private String surname;
    private String fatherName;

    public Person() {

    }
    public Person(Cafedra cafedra, String name, String surname, String fatherName) {
        this.cafedra = cafedra;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Person{" +
                ", cafedraId=" + cafedra +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }


    public Cafedra getCafedra() {
        return cafedra;
    }

    public void setCafedra(Cafedra cafedra) {
        this.cafedra = cafedra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }


}