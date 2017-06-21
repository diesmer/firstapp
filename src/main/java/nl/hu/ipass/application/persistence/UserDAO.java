package nl.hu.ipass.application.persistence;

import java.util.ArrayList;

public interface UserDAO {

	public ArrayList<User> GetAllUsers();

	public User getUser(int id);

	public boolean AddUser(User u);

	public boolean UpdateUser(User u);

	public boolean DeleteUser(User u);

}
