package studentmanagement;

public interface StudentOperations {

    void addStudent(Student s);

    void displayStudents();

    void filterTopStudents();

    void filterFailedStudents();

    void filterByCourse(String course);

    void searchByName(String name);
}