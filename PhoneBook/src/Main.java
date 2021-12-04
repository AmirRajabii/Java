import java.sql.SQLException;
import java.util.Scanner;

import Business.Contacts;

public class Main {

	public static void main(String[] args) {
		Contacts contatsMain = new Contacts();
		String name = "";
		String nameJ = "";
		String phone = "";
		String phoneJ = "";
		int num = 0, id = 0;
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
			switch (num) {
			// Add Contact --------------------------------------------------
			case 1:
				System.out.print("Contact Name : ");
				name = new Scanner(System.in).nextLine();
				System.out.print("Contact PhoneNumber : ");
				phone = new Scanner(System.in).nextLine();
				if (contatsMain.fncAdd(name, phone)) {
					System.out.println("!! Contact Created !! ");
					System.out.println("------------------------");
				} else {
					System.out.println("!! Contact Not Created !! ");
					System.out.println("------------------------");
				}
				break;
			// Delete Contact --------------------------------------------------Z
			case 2:
				System.out.println(" Contact List ");
				contatsMain.fncShow(contatsMain.fncContactList());
				System.out.print("Enter Number Of ID For Delete Contact : ");
				id = new Scanner(System.in).nextInt();
				if (contatsMain.fncDelete(id)) {
					System.out.println(" !! Contact Deleted !! ");
					System.out.println("-----------------");
				} else {
					System.out.println("Not Found");
				}
				break;
			// Update Contact --------------------------------------------------
			case 3:
				System.out.println(" Contact List ");
				contatsMain.fncShow(contatsMain.fncContactList());
				System.out.print("Enter Number Of ID For Update Contact : ");
				id = new Scanner(System.in).nextInt();
				try {
					if (!contatsMain.fncFindId(id).next()) {
						System.out.println("Contact Not Found");
						break;
					}
					nameJ = contatsMain.fncFindId(id).getString("name");
					phoneJ = contatsMain.fncFindId(id).getString("phonenumber");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.print("Enter New Name (Enter (0) for No Change) : ");
				name = new Scanner(System.in).nextLine();
				if (name.equalsIgnoreCase("0")) {
					name = nameJ;
				}
				System.out.print("Enter New Number (Enter (0) for No Change) : ");
				phone = new Scanner(System.in).nextLine();
				if (phone.equalsIgnoreCase("0")) {
					phone = phoneJ;
				}
				if (contatsMain.fncUpdate(id, name, phone)) {
					System.out.println(" !! Contact Updated !! ");
					System.out.println("------------------------");
				} else {
					System.out.println("Update Faild");
				}
				break;
			// Find Contact ----------------------------------------------------
			case 4:
				System.out.print("Enter Name Of Contact To Find : ");
				name = new Scanner(System.in).nextLine();
				contatsMain.fncShow(contatsMain.fncFind(name));
				try {
					if (!contatsMain.fncFind(name).next()) {
						System.out.println("Contact Not Found");
						System.out.println("------------------------");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			// Show Contact ---------------------------------------------------------
			case 5:
				System.out.println(" Contact List ");
				contatsMain.fncShow(contatsMain.fncContactList());
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

	}
}