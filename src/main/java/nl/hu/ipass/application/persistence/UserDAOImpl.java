package nl.hu.ipass.application.persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import nl.hu.ipass.application.persistence.SQLConnection;

public class UserDAOImpl implements UserDAO {
	private SQLConnection sqlconn = null;

	public UserDAOImpl() {
		sqlconn = new SQLConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/ipass", "postgres",
				"root");
	}

	public ArrayList<User> GetAllUsers() {
		ArrayList<User> result = new ArrayList<User>();
		try {
			sqlconn.setTable("User");
			ResultSet rs = sqlconn.Retrieve(String.format("Select * from \"%s\"", sqlconn.getTable()));
			while (rs.next()) {
				result.add(new User(rs.getInt("id"), rs.getString("role"), rs.getString("voornaam"),
						rs.getString("achternaam"), rs.getString("geboortedatum"), rs.getString("wachtwoord"),
						rs.getString("emailadres")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public User getUser(int id) {
		try {
			sqlconn.setTable("User");
			ResultSet rs = sqlconn.Retrieve(String.format("select * from \"%s\" where id= %d", sqlconn.getTable(), id));

			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("role"), rs.getString("voornaam"),
						rs.getString("achternaam"), rs.getString("geboortedatum"), rs.getString("wachtwoord"),
						rs.getString("emailadres"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean AddUser(User u) {
		try {
			sqlconn.setTable("User");
			if (sqlconn.Update(String.format(
					"insert into \"%s\" (id, role, voornaam, achternaam, geboortedatum, wachtwoord, emailadres) values (%d, '%s', '%s', '%s', '%s', '%s', '%s')",
					sqlconn.getTable(), u.getID(), u.getRole(), u.getVoornaam(), u.getAchternaam(),
					u.getGeboortedatum(), u.getWachtwoord(), u.getEmailadres()))) {
				return true;
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean UpdateUser(User u) {
		try {
			sqlconn.setTable("User");
			if (sqlconn.Update("UPDATE user SET id= " + u.getID() + ", role= '" + u.getRole() + "', voornaam='"
					+ u.getVoornaam() + "', achternaam='" + u.getAchternaam() + "', geboortedatum='"
					+ u.getGeboortedatum() + "', wachtwoord='" + u.getWachtwoord() + "', emailadres='"
					+ u.getEmailadres() + "', WHERE id=" + u.getID())) {
				return getUser(u.getID()) != null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean DeleteUser(User u) {
		try {
			sqlconn.setTable("User");
			if (sqlconn.Update(String.format("DELETE FROM \"%s\" WHERE id = %d", sqlconn.getTable(), u.getID())))
				;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
