package JDBC_CONN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stud_CRUD {
	
	void insertStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "root");
	
			Statement stmt = con.createStatement();
	
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
			while (rs.next()) {
				System.out.println("Name: " + rs.getString(1) + ", ID: " + rs.getInt(2) + ", Stud_Dept: " + rs.getString(3));
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void insertStudent1() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "root");

	        Statement stmt = con.createStatement();

	        String name = "Pravin";
	        int id = 4;
	        String department = "CSe";

	        String sqlQuery = "INSERT INTO students (name, id, stud_dept) VALUES ('" + name + "', " + id + ", '" + department + "')";

	        int rowsAffected = stmt.executeUpdate(sqlQuery);
	        if (rowsAffected > 0) {
	            System.out.println("Student data inserted successfully.");
	        } else {
	            System.out.println("Failed to insert student data.");
	        }

	        stmt.close();
	        con.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}void deleteStudent(int studentId) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "root");

	        Statement stmt = con.createStatement();

	        String sqlQuery = "DELETE FROM students WHERE id = " + studentId;

	        int rowsAffected = stmt.executeUpdate(sqlQuery);
	        if (rowsAffected > 0) {
	            System.out.println("Student with ID " + studentId + " deleted successfully.");
	        } else {
	            System.out.println("No student found with ID " + studentId + ".");
	        }

	        stmt.close();
	        con.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	
	public static void main(String[] args) {
		Stud_CRUD obj = new Stud_CRUD();
		obj.insertStudent();
		obj.insertStudent1();
		obj.deleteStudent(4);
	}
}
