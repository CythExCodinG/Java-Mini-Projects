
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private static final String FILE_NAME = "students.dat";

    private ArrayList<Student> students;

    public StudentManager() {
        students = loadStudents();
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Student> loadStudents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            return (ArrayList<Student>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load student records: "
                    + e.getMessage());

            return new ArrayList<>();
        }
    }

    private void saveStudents() {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            out.writeObject(students);

        } catch (IOException e) {
            System.out.println("Error saving students: "
                    + e.getMessage());
        }
    }

    public void addStudent(Student student) {

        if (searchStudent(student.getId()) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        students.add(student);
        saveStudents();

        System.out.println("Student added successfully!");
    }

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            System.out.println("--------------------");
            System.out.println(student);
        }
    }

    public Student searchStudent(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}
