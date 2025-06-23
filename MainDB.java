import java.sql.*;
import java.util.Scanner;

public class MainDB {
    static final String URL = "jdbc:mysql://localhost:3306/Student";
    static final String USER = "Ratul";
    static final String PASS = "1234";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Java is successfully connected to MySQL server.");

            while (true) {
                System.out.println("\n1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit the Student Menu");
                System.out.print("Choose option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        AddStudent.add(conn, scanner);
                        break;
                    case 2:
                        ViewStudents.view(conn);
                        break;
                    case 3:
                        UpdateStudent.update(conn, scanner);
                        break;
                    case 4:
                        DeleteStudent.delete(conn, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting the Student Menu...");
                        return;
                    default:
                        System.out.println("Oops! You have entered an incorrect option. Please try again");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
