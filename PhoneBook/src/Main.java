import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	static Boolean chk = false;
	static String name = "";
	static int ac = 0;
	static String Phone = "";

	public static void main(String[] args) {
		Connection con;
		int num = 0;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:Phonebook.db");
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM user");
			while (true) {
				// Menu -----------------------------------------
				System.out.println("1.Add Contact");
				System.out.println("2.Delete Contact");
				System.out.println("3.Update Contact");
				System.out.println("4.Search Contact");
				System.out.println("5.Contact List");
				System.out.println("6.Exit");
				System.out.println("-----------------");
				// -----------------------------------------------
				System.out.print("Enter a Number : ");
				num = new Scanner(System.in).nextInt();
				fncMenu(st, result, num);
			} // end of while

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static private void fncMenu(Statement st, ResultSet result, int num) {
		switch (num) {
		// Add Contact --------------------------------------------------
		case 1:
			fncAdd(st);
			break;
		// Delete Contact --------------------------------------------------Z
		case 2:
			fncContactList(st, result);
			fncDelete(st);
			break;
		// Update Contact --------------------------------------------------
		case 3:
			fncContactList(st, result);
			fncUpdate(st);
			break;
		// Find Contact ----------------------------------------------------
		case 4:
			fncFind(st, result);
			chk = false;
			break;
		// Show Contact ---------------------------------------------------------
		case 5:
			fncContactList(st, result);
			break;
		// Exit -----------------------------------------------------------------
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong Number --- Please Try Agin ");
			break;
		}
	}

	static private void fncContactList(Statement st, ResultSet result) {
		try {
			result = st.executeQuery("SELECT * FROM user");
			while (result.next()) {
				System.out.println("Id : " + result.getString("id") + "   Name : " + result.getString("name")
						+ "    Number : " + result.getString("phonenumber"));
				System.out.println("-----------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(" Cotact List ");

	}

	static private void fncFind(Statement st, ResultSet result) {
		try {
			result = st.executeQuery("SELECT * FROM user");
			System.out.print("Enter Name Of Contact To Find : ");
			name = new Scanner(System.in).nextLine();
			while (result.next()) {
				if (name.equalsIgnoreCase(result.getString("name"))) {
					System.out.println("!! Contact Found !! ");
					System.out.println("Id : " + result.getString("id") + "   Name : " + result.getString("name")
							+ "    Number : " + result.getString("phonenumber"));
					System.out.println("------------------------------");
					chk = true;
				}
			}
			if (!chk) {
				System.out.println("Not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	static private void fncUpdate(Statement st) {
		System.out.print("Enter Number Of ID For Update Contact : ");
		ac = new Scanner(System.in).nextInt();
		System.out.print("Enter New Name : ");
		name = new Scanner(System.in).nextLine();
		System.out.print("Enter New Number : ");
		Phone = new Scanner(System.in).nextLine();
		try {
			if (st.executeUpdate(
					"UPDATE user SET name='" + name + "' , phonenumber='" + Phone + "' WHERE id=" + ac) == 1) {
				System.out.println(" !! Contact Updated !! ");
				System.out.println("------------------------");
			} else {
				System.out.println("Update Faild");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static private void fncAdd(Statement st) {
		System.out.print("Contact Name : ");
		name = new Scanner(System.in).nextLine();
		System.out.print("Contact PhoneNumber : ");
		Phone = new Scanner(System.in).nextLine();
		try {
			st.executeUpdate("INSERT INTO user (name , phonenumber) VALUES ('" + name + "' , '" + Phone + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("!! Contact Created !! ");
		System.out.println("------------------------");
	}

	static private void fncDelete(Statement st) {
		System.out.print("Enter Number Of ID For Delete Contact : ");
		ac = new Scanner(System.in).nextInt();
		try {
			if (st.executeUpdate("DELETE FROM user WHERE id=" + ac) == 1) {
				System.out.println(" !! Contact Deleted !! ");
				System.out.println("-----------------");
			} else {
				System.out.println("Not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
