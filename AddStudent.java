import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddStudent {
    public static void add(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter a student name to insert: ");
        String name = scanner.nextLine();

        String sql = "INSERT INTO student(name) VALUES (?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student added successfully.");
        }
    }
}
