package nl.hu.ipass.application.webservices;

import nl.hu.ipass.application.persistence.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainService {
	private List<User> allUsers;
	private UserDAO udao;
	
	private List<Afspraak> allAfspraken;
	private AfspraakDAO adao;
	
	public MainService() {
		udao = new UserDAOImpl();
		allUsers = udao.GetAllUsers();
		
		adao = new AfspraakDAOImpl();
		allAfspraken = adao.GetAllAfspraken();
	}
	
	public List<User> getAllUsers() {
		return allUsers;
	}
	
	public List<Afspraak> getAllAfspraken() {
		return allAfspraken;
	}
	
	public User getUserByID(String id) {
		User result = null;
		int id2 = Integer.parseInt(id);
		
		for ( User u: allUsers) {
			if (u.getID() == id2) {
				result = u;
			}
		}
		return result;
	}
	
	public Afspraak getAspraakByID(String id) {
		Afspraak result = null;
		int id2 = Integer.parseInt(id);
		
		for ( Afspraak a: allAfspraken) {
			if (a.getID() == id2) {
				result = a;
			}
		}
		return result;
	}
	
	public boolean updateUser(User u) {
		udao.UpdateUser(u);
		return true;
	}
	
	public boolean updateAfspraak(Afspraak a) {
		adao.UpdateAfspraak(a);
		return true;
	}
	
	public boolean removeUser(User u) {
		return udao.DeleteUser(u);
	}
	
	public boolean removeAfspraak(Afspraak a) {
		return adao.DeleteAfspraak(a);
	}
	
	public boolean newUser(User u) {
		udao.AddUser(u);
		return true;
	}
	
	public boolean newAfspraak(Afspraak a) {
		adao.AddAfspraak(a);
		return true;
	}
}
