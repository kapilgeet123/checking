import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateData {
 public static void main(String[] args) {
	 Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			// 2. Open the connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch64?useSSL=false", "root", "12345678");
			// 3. Issue the query
			PreparedStatement ps = conn.prepareStatement("select * from employees");
			// execute query
			ResultSet rs = ps.executeQuery();

			// Fetch result
			while (rs.next()) {
				System.out.print("Id=" + rs.getInt(1));
				System.out.print("Name=" + rs.getString(2));
				System.out.print("Dept=" + rs.getString(3));
				System.out.print("Salary=" + rs.getFloat(4));
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
}
}
