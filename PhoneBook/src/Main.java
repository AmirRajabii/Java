import java.sql.SQLException;
import java.util.Scanner;

import Business.Contats;

public class Main {

	public static void main(String[] args) {
		Contats contatsMain = new Contats();
		String name = "";
		String phone = "";
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
				if (contatsMain.fncAdd(name, phone) == true) {
					System.out.println("!! Contact Created !! ");
					System.out.println("------------------------");
				} else {
					System.out.println("!! Contact Not Created !! ");
					System.out.println("------------------------");
				}
				break;
			// Delete Contact --------------------------------------------------Z
			case 2:
				System.out.println(" Cotact List ");
				contatsMain.fncShow(contatsMain.fncContactList());
				System.out.print("Enter Number Of ID For Delete Contact : ");
				id = new Scanner(System.in).nextInt();
				if (contatsMain.fncDelete(id) == true) {
					System.out.println(" !! Contact Deleted !! ");
					System.out.println("-----------------");
				} else {
					System.out.println("Not Found");
				}
				break;
			// Update Contact --------------------------------------------------
			case 3:
				System.out.println(" Cotact List ");
				contatsMain.fncShow(contatsMain.fncContactList());
				System.out.print("Enter Number Of ID For Update Contact : ");
				id = new Scanner(System.in).nextInt();
				System.out.print("Enter New Name : ");
				name = new Scanner(System.in).nextLine();
				System.out.print("Enter New Number : ");
				phone = new Scanner(System.in).nextLine();
				if (contatsMain.fncUpdate(id, name, phone) == true) {
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

				break;
			// Show Contact ---------------------------------------------------------
			case 5:
				System.out.println(" Cotact List ");
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