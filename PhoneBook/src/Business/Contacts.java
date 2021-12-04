package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

import Data.ContactsDb;

public class Contacts {
	ContactsDb conts = new ContactsDb();

	public Boolean fncAdd(String name, String phone) {
		return conts.fncAdd(name, phone);

	}

	public Boolean fncDelete(int id) {
		return conts.fncDelete(id);
	}

	public Boolean fncUpdate(int id, String name, String phone) {
		return conts.fncUpdate(id, name, phone);
	}

	public ResultSet fncContactList() {
		return conts.fncContactList();
	}

	public ResultSet fncFind(String name) {
			return conts.fncFind(name);
	
	}

	public void fncShow(ResultSet result) {
		try {
			while (result.next()) {
				System.out.println("Id : " + result.getString("id") + "   Name : " + result.getString("name")
						+ "    Number : " + result.getString("phonenumber"));
				System.out.println("-----------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public ResultSet fncFindId(int id) {
		return conts.fncFindId(id);

	}
}
