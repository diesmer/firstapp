package nl.hu.ipass.application.persistence;

import java.util.ArrayList;

public interface AfspraakDAO {

	public ArrayList<Afspraak> GetAllAfspraken();

	public Afspraak getAfspraak(int id);

	public boolean AddAfspraak(Afspraak a);

	public boolean UpdateAfspraak(Afspraak a);

	public boolean DeleteAfspraak(Afspraak a);

}
