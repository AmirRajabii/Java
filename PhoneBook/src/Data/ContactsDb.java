package Data;

import Business.Vars;
import java.sql.ResultSet;

public class ContactsDb {

	public Boolean fncAdd(String name, String phone) {
		return Vars.clsDbTasks
				.fncRunCommands("INSERT INTO user (name , phonenumber) VALUES ('" + name + "' , '" + phone + "')");
	}

	public Boolean fncDelete(int id) {
		return Vars.clsDbTasks.fncRunCommands("DELETE FROM user WHERE id=" + id);
	}

	public Boolean fncUpdate(int id, String name, String phone) {
		return Vars.clsDbTasks
				.fncRunCommands("UPDATE user SET name='" + name + "' , phonenumber='" + phone + "' WHERE id=" + id);
	}

	public ResultSet fncContactList() {
		return Vars.clsDbTasks.fncSelect("SELECT * FROM user");
	}

	public ResultSet fncFind(String name) {
		return Vars.clsDbTasks.fncSelect("SELECT * FROM user WHERE name='" + name + "'");
	}
	
	public ResultSet fncFindId(int id) {
		return Vars.clsDbTasks.fncSelect("SELECT * FROM user WHERE id='" + id + "'");
	}

}