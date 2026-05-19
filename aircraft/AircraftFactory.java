package aircraft;

import java.util.concurrent.atomic.AtomicLong;

public class AircraftFactory {

	private static AtomicLong idGenerator = new AtomicLong(0); // threadsafe long

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws Throwable {
		long id = idGenerator.getAndIncrement();
		switch (p_type) {
			case "Helicopter":
				return new Helicopter(id, p_name, p_coordinates);
			case "Balloon":
				return new Balloon(id, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(id, p_name, p_coordinates);
			default:
				// TODO: update
				throw new Throwable("test");
		}
	}

	// SINGLETON
	private static volatile AircraftFactory _instance;

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		if (_instance != null)
			return _instance;
		synchronized(AircraftFactory.class) {
			if (_instance == null) {
				_instance = new AircraftFactory();
			}
		}
		return _instance;
	}

}
