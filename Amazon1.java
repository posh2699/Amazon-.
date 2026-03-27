package New;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Amazon1 {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/task";
		String un = "root";
		String pw = "root123";
		String query = "select * from amazon  where product_id = ? and product_name = ? and price = ? and descript = ? "
				+ "and brand = ? and category = ? " ;
 
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("loaded successfully");
		
	    Connection con =	DriverManager.getConnection(url, un, pw);
		System.out.println("conneted Succesfully");
		
		
		PreparedStatement pstmt =    con.prepareStatement(query);
		
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


		 ResultSet  res  = pstmt.executeQuery();
		 
		 
		 if(res.next())
		 {
			 System.out.println("Data fetched succesFully");
	 
		 }
		 else{
			 System.out.println("invaild cer");
		 }
		 
		 
		 pstmt.close();
		 
		 con.close();
		 
	}
		 

}