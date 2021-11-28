import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	static byte day = 1, enter = 7, exit = 8;
	static int hSalary = 0;
	static String name;
	static long fSalary;

	public static void main(String[] args) {
		int num = 0;
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:CCSalary.db");
			Statement st = con.createStatement();
			while (true) {
				// Menu -----------------------------------------
				System.out.println("1.Add Person");
				System.out.println("2.Show All Person");
				System.out.println("3.Exit");
				System.out.println("-----------------");
				// -----------------------------------------------
				System.out.print("Enter a Number : ");
				num = new Scanner(System.in).nextInt();
				fncSwitch(num, st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static private void fncSwitch(int num, Statement st) {
		switch (num) {
		case 1:
			fncAdd(st);
			break;
		case 2:
			fncShow(st);
			break;
		case 3:
			System.exit(0);
			break;

		default:
			System.out.println("---------------------------------");
			System.out.println("Wrong Number --- Please Try Agin ");
			System.out.println("---------------------------------");
			break;
		}
	}

	static private void fncAdd(Statement st) {

		System.out.print("Please Enter Name : ");
		name = new Scanner(System.in).nextLine();
		System.out.print("Please Enter Number Of Work Days : ");
		day = new Scanner(System.in).nextByte();
		if (day > 31 || day < 1) {
			System.out.println("Wrong Value , Try Again (1--31) ");
			System.out.println("--------------------------------");

		} else {
			System.out.print("Please Enter Salary Per Hour : ");
			hSalary = new Scanner(System.in).nextInt();
			for (int i = 0; i < day; i++) {
				System.out.print("Please Enter H (7--23) Enter (Day " + (i + 1) + " ) : ");
				enter = new Scanner(System.in).nextByte();
				System.out.print("Please Enter H (7--23) Exit (Day " + (i + 1) + " ) : ");
				exit = new Scanner(System.in).nextByte();
				if (exit < 8 || exit > 23 || enter < 7 || enter > 10) {
					System.out.println("Wrong Value , Try Again (7--23) ");
					System.out.println("--------------------------------");
					i-=1;
					fSalary -= ((exit - enter) * hSalary);
				} 
				 
				fSalary += ((exit - enter) * hSalary);
		}
			try {
				st.executeUpdate("INSERT INTO person (name , hsalary , fullsalary ) VALUES ('" + name + "' , '"
						+ hSalary + "' , '" + fSalary + "')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("-----------------");
			System.out.println(" Done !!!! ");
			System.out.println("Full Salary Of " + name + " is : " + fSalary);
			System.out.println("-----------------");
		}
	}				

	static private void fncShow(Statement st) {
		System.out.println("<<< Full List >>> ");
		ResultSet result;
		try {
			result = st.executeQuery("SELECT * FROM person");
			while (result.next()) {
				System.out.println("Id : " + result.getString("id") + "   Name : " + result.getString("name")
						+ "    Salary Per Hour : " + result.getString("hsalary") + "     Full Salary : "
						+ result.getString("fullsalary"));
				System.out.println("-----------------------------------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
