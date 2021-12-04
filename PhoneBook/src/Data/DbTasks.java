package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbTasks {
	private static String ConDb = "jdbc:sqlite:Phone.db";
	private  Boolean chk = false;
	private  Connection con;
	private  Statement st;
	private static Boolean blnIsInstanceCreated = false;

	private DbTasks(){
	}
	
	public static DbTasks getInstance() {
		if(!blnIsInstanceCreated) {
			blnIsInstanceCreated = true;
		return new DbTasks();
		}
		else return null;
	}


	private void fncOpen() {
		try {
			if (chk == false) {
				con = DriverManager.getConnection(ConDb);
				st = con.createStatement();
				chk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		chk = true;
	}

	private void fncClose() {
		try {
			if (chk == true) {
				con.close();
				st.close();
				chk = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chk = false;
	}

	public Boolean fncRunCommands(String query) {
		fncOpen();
		try {
			if (st.executeUpdate(query) == 1) {
				fncClose();
				return true;
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		fncClose();
		return false;
	}

	public ResultSet fncSelect(String query) {
		fncOpen();
		ResultSet result = null;
		try {
			result = st.executeQuery(query);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fncClose();
		return result;
	}
}
