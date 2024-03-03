package src.Interfaces;

import src.Model.Cafedra;

/**
 * Represents a person entity in the system.
 */
public class Person {
    private Cafedra cafedra; // The department to which the person belongs
    private String name; // The name of the person
    private String surname; // The surname of the person
    private String fatherName; // The father's name of the person

    /**
     * Constructs a new Person object.
     */
    public Person() {
    }

    /**
     * Constructs a new Person object with specified parameters.
     *
     * @param cafedra    The department to which the person belongs.
     * @param name       The name of the person.
     * @param surname    The surname of the person.
     * @param fatherName The father's name of the person.
     */
    public Person(Cafedra cafedra, String name, String surname, String fatherName) {
        this.cafedra = cafedra;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return A string representation of the person.
     */
    @Override
    public String toString() {
        return "Person{" +
                "cafedra=" + cafedra +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }

    /**
     * Gets the department of the person.
     *
     * @return The department of the person.
     */
    public Cafedra getCafedra() {
        return cafedra;
    }

    /**
     * Sets the department of the person.
     *
     * @param cafedra The department of the person to set.
     */
    public void setCafedra(Cafedra cafedra) {
        this.cafedra = cafedra;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The name of the person to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the surname of the person.
     *
     * @return The surname of the person.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the person.
     *
     * @param surname The surname of the person to set.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the father's name of the person.
     *
     * @return The father's name of the person.
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * Sets the father's name of the person.
     *
     * @param fatherName The father's name of the person to set.
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
