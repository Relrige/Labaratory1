public enum MenuChoice {
    FACULTY("Факультет"),
    DEPARTMENT("Створити кафедру факультета"),
    MEMBER("Додати студента/викладача до кафедри"),
    FIND_BY_NAME("Знайти студента/викладача за ПІБ"),
    FIND_BY_COURSE("Знайти студента/викладача за курсом"),
    FIND_BY_GROUP("Знайти студента/викладача за групою"),
    SORT_BY_COURSE("Вивести всіх студентів впорядкованих за курсами"),
    SORT_BY_NAME("Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом"),
    SORT_DEPARTMENT_MEMBERS_BY_COURSE("Вивести всіх студентів кафедри впорядкованих за курсами"),
    SORT_DEPARTMENT_MEMBERS_BY_NAME("Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом"),
    FILTER_DEPARTMENT_MEMBERS_BY_COURSE("Вивести всіх студентів кафедри вказаного курсу"),
    FILTER_DEPARTMENT_MEMBERS_BY_COURSE_SORTED("Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом");
    private final String description;
    Action(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public String getDescription() {
        return description;
    }
}