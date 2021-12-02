package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.core.DB;

public class DbTasks {
	private static String ConDb = "jdbc:sqlite:Phonebook.db";
	private static Boolean chk = false;
	private static Connection con;
	private static Statement st;

	public static  DbTasks instance;

	DbTasks() {
	}

	public static DbTasks getInstance() {
		if(instance==null) {
			synchronized (DbTasks.class) {
				if(instance==null) {
					instance=new DbTasks();
				}
			}
		}
		return instance;
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
			} else {
				fncClose();
				return false;
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
