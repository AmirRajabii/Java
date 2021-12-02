package Data;

import java.sql.ResultSet;

public class ContatsDb {

	DbTasks ContDb = DbTasks.getInstance();

	public Boolean fncAdd(String name, String phone) {
		return ContDb.fncRunCommands("INSERT INTO user (name , phonenumber) VALUES ('" + name + "' , '" + phone + "')");
	}

	public Boolean fncDelete(int id) {
		return ContDb.fncRunCommands("DELETE FROM user WHERE id=" + id);
	}

	public Boolean fncUpdate(int id, String name, String phone) {
		return ContDb
				.fncRunCommands("UPDATE user SET name='" + name + "' , phonenumber='" + phone + "' WHERE id=" + id);
	}

	public ResultSet fncContactList() {
		return ContDb.fncSelect("SELECT * FROM user");
	}

	public ResultSet fncFind(String name) {
		return ContDb.fncSelect("SELECT * FROM user WHERE name='" + name + "'");
	}

}