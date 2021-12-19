package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

import Data.UserScoreDb;

public class UserScore {
	UserScoreDb userDb = new UserScoreDb();

	public Boolean fncAddName(String firstname, String lastname, String username, String password) {
		return userDb.fncAddName(firstname, lastname, username, password);
	}

	public Boolean fncAddScore(String username, String score, String date) {
		return userDb.fncAddScore(username, score, date);
	}

	public Boolean fncChekLogin(String username, String password) {
		return userDb.fncChekLogin(username, password);
	}

	public ResultSet fncScoreList() {
		return userDb.fncScoreList();
	}

	public ResultSet fncFindScore(String username) {
		return userDb.fncFindScore(username);
	}

	public void fncShowScore(ResultSet result) {
		try {
			while (result.next()) {
				System.out.println("Id : " + result.getString("id") + "   UserName : " + result.getString("username")
						+ "    Score : " + result.getString("score"));
				System.out.println("-----------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
