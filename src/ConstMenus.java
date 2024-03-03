package src;

/**
 * This class contains constant menu texts for the application.
 */
public class ConstMenus {

    /**
     * The main menu text for the application.
     */
    static final String mainMenuText = """
        
        1. Створити/видалити/редагувати факультет.
        2. Створити/видалити/редагувати кафедру факультета.
        3. Додати/видалити/редагувати студента/викладача до кафедри.
        4. Знайти студента/викладача за ПІБ, курсом або групою.
        5. Вивести всіх студентів впорядкованих за курсами.
        6. Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.
        7. Вивести всіх студентів спеціальності впорядкованих за курсами.
        8. Вивести всіх студентів спеціальності/викладачів кафедри впорядкованих за алфавітом.
        9. Вивести всіх студентів спеціальності вказаного курсу.
        10. Вивести всіх студентів спеціальності вказаного курсу впорядкованих за алфавітом.
        """;

    /**
     * The menu text for options related to creating, editing, and deleting items.
     */
    static final String changeMenu = """
        1. Create.
        2. Edit.
        3. Delete.
        4. Exit
        """;

    /**
     * The menu text for selecting between student and professor options.
     */
    static final String studentOrProfessor = """
        1. Student.
        2. Professor.
        3. Exit
        """;
}
