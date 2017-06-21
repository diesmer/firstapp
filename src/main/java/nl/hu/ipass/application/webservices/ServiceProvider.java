package nl.hu.ipass.application.webservices;

public class ServiceProvider {
	private static MainService worldService = new MainService();

	public static MainService getWorldService() {
		return worldService;
	}
}