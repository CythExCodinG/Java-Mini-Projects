
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter student ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter age: ");
                        int age = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter course: ");
                        String course = sc.nextLine();

                        if (id <= 0 || age <= 0
                                || name.isBlank()
                                || course.isBlank()) {
                            System.out.println(
                                    "Enter valid student details.");
                            break;
                        }

                        manager.addStudent(
                                new Student(id, name, age, course));
                        break;

                    case 2:
                        manager.viewStudents();
                        break;

                    case 3:
                        System.out.print("Enter student ID: ");
                        int searchId =
                                Integer.parseInt(sc.nextLine());

                        Student student =
                                manager.searchStudent(searchId);

                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        System.out.println("Exiting application...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid menu choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid number.");
            }
        }
    }
}
