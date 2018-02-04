package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindInfoInDB {

	private static ResultSet executeQuery(String query) {
		DBConnection connection = new DBConnection();
		ResultSet rs = null;
		try {
			Statement st = connection.getConnection().createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public String getEmail() throws SQLException {
		String query = "select email from employee where employee_id=3";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("email");
	}

	public String getName() throws SQLException {
		String query = "select first_name from employee where employee_id=3";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("first_name");
	}
	
	public String getName2() throws SQLException {
		String query = "select last_name from employee where employee_id=3";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("last_name");
	}

	public String getPhone() throws SQLException {
		String query = "select phone from employee where employee_id=3";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("phone");
	}

	public String getSkype() throws SQLException {
		String query = "select im from employee where employee_id=3";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("im");
	}

	public String getUnit() throws SQLException {
		String query = "select unit_name from unit where unit_id=1";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("unit_name");
	}

	public String getLocation() throws SQLException {
		String query = "select name from location where location_id=1";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("name");
	}

	public String getCountry() throws SQLException {
		String query = "select country from location where location_id=1";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("country");
	}

	public String getCity() throws SQLException {
		String query = "select city from location where location_id=1";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("city");
	}

	public String getOfficce() throws SQLException {
		String query = "select office from location where location_id=1";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("office");
	}

	public String getSpecialization() throws SQLException {
		String query = "select name from specialization where specialization_id=2";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("name");
	}

	public String getWorkStation() throws SQLException {
		String query = "select workstation from employee where employee_id=3";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("workstation");
	}

	public String getComment() throws SQLException {
		String query = "select rm_comment from employee where employee_id=3";
		ResultSet rs = executeQuery(query);
		rs.next();
		return rs.getString("rm_comment");
	}
}
