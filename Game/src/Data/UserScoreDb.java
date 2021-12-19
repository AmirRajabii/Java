package Data;

import Business.Vars;
import java.sql.ResultSet;

public class UserScoreDb {

	public Boolean fncAddName(String firstname, String lastname, String username, String password) {
		return Vars.clsDbTasks.fncRunCommands("INSERT INTO user (firstname , lastname , username , password) VALUES ('"
				+ firstname + "' , '" + lastname + "' , '" + username + "' , '" + password + "')");
	}

	public Boolean fncAddScore(String username, String score, String date) {
		return Vars.clsDbTasks.fncRunCommands("INSERT INTO Scores (username , score , date) VALUES ('" + username
				+ "' , '" + score + "' , '" + date + "')");
	}

	public ResultSet fncScoreList() {
		return Vars.clsDbTasks.fncSelect("SELECT * FROM Scores");
	}

	public ResultSet fncFindScore(String username) {
		return Vars.clsDbTasks.fncSelect("SELECT username,score FROM Scores WHERE username='" + username + "'");
	}

	public Boolean fncChekLogin(String username, String password) {
		return Vars.clsDbTasks.fncRunCommands("UPDATE user SET username='" + username + "' , password='" + password
				+ "' WHERE username='" + username + "' AND password='" + password + "'");
	}

}