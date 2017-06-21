package nl.hu.ipass.application.persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import nl.hu.ipass.application.persistence.SQLConnection;

public class AfspraakDAOImpl implements AfspraakDAO {
	private SQLConnection sqlconn = null;

	public AfspraakDAOImpl() {
		sqlconn = new SQLConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/ipass", "postgres",
				"root");
	}

	public ArrayList<Afspraak> GetAllAfspraken() {
		ArrayList<Afspraak> result = new ArrayList<Afspraak>();
		try {
			sqlconn.setTable("Afspraak");
			ResultSet rs = sqlconn.Retrieve(String.format("Select * FROM \"%s\"", sqlconn.getTable()));
			while (rs.next()) {
				result.add(new Afspraak(rs.getInt("id"), rs.getString("naam_behandeling"), rs.getString("datum"),
						rs.getString("tijd"), rs.getInt("lengte"), rs.getInt("user_id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Afspraak getAfspraak(int id) {
		try {
			sqlconn.setTable("Afspraak");
			ResultSet rs = sqlconn.Retrieve(String.format("Select * FROM \"%s\" WHERE id= %d", sqlconn.getTable(), id));

			if (rs.next()) {
				return new Afspraak(rs.getInt("id"), rs.getString("naam_behandeling"), rs.getString("datum"),
						rs.getString("tijd"), rs.getInt("lengte"), rs.getInt("user_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean AddAfspraak(Afspraak a) {

		try {
			sqlconn.setTable("Afspraak");
			if (sqlconn.Update(String.format(
					"insert into \"%s\" (id, naam_behandeling, datum, tijd, lengte, user_id) values (%d, '%s', '%s', '%s', %d, %d)",
					sqlconn.getTable(), a.getID(), a.getNaam_Behandeling(), a.getDatum(), a.getTijd(), a.getLengte(),
					a.getUser_ID()))) {
				return true;
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean UpdateAfspraak(Afspraak a) {
		try {
			sqlconn.setTable("Afspraak");
			if (sqlconn.Update(String.format(
					"UPDATE \"%s\" SET id= %d, naam_behandeling = '%s', datum = '%s', tijd = '%s', lengte = '%s', WHERE id=%d",
					sqlconn.getTable(), a.getID(), a.getNaam_Behandeling(), a.getDatum(), a.getTijd(),
					a.getLengte()))) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean DeleteAfspraak(Afspraak a) {
		try {
			if (sqlconn.Update(String.format("DELETE FROM \"%s\" WHERE id = %d", sqlconn.getTable(), a.getID())))
				;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
