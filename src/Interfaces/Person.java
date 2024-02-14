package src.Interfaces;

public class Person {
    private int id;
    private int cafedraId;
    private String name;
    private String surname;
    private String fatherName;


    public Person(int id, int cafedraId, String name, String surname, String fatherName) {
        this.id = id;
        this.cafedraId = cafedraId;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Person{" +
                "id=" + id +
                ", cafedraId=" + cafedraId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCafedraId() {
        return cafedraId;
    }

    public void setCafedraId(int cafedraId) {
        this.cafedraId = cafedraId;
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