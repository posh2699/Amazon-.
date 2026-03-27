package New;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Amazon {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/task";
		String un = "root";
		String pw = "root123";
		String query = "insert into amazon values (? , ? , ? , ? , ? , ?)";

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("loaded sucesffuly");

		Connection con = DriverManager.getConnection(url, un, pw);
		System.out.println("conneted Succesfully");

		PreparedStatement pstmt = con.prepareStatement(query);

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter product_id:");
        String pid = sc.nextLine();

        System.out.println("Enter product_name:");
        String pn = sc.nextLine();

        System.out.println("Enter price:");
        int price = sc.nextInt();   // price should be INT
        sc.nextLine(); // consume newline

        System.out.println("Enter description:");
        String des = sc.nextLine();

        System.out.println("Enter brand:");
        String br = sc.nextLine();

        System.out.println("Enter category:");
        String cat = sc.nextLine();
        
        pstmt.setString(1, pid);
        pstmt.setString(2, pn);
        pstmt.setInt(3, price);
        pstmt.setString(4, des);
        pstmt.setString(5, br);
        pstmt.setString(6, cat);

		pstmt.executeUpdate();

		System.out.println("Added to feed SuccesFULLY");

		pstmt.close();

		con.close();

	}

}
	
