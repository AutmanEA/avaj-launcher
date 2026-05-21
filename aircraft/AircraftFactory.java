package aircraft;

import java.util.concurrent.atomic.AtomicLong;

import bonus.AircraftFactoryException;

public class AircraftFactory {

	private static AtomicLong idGenerator = new AtomicLong(0); // threadsafe long

	public static Coordinates setCoordinates(int lon, int lat, int height) {
		return new Coordinates(lon, lat, height);
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws AircraftFactoryException {
		long id = idGenerator.getAndIncrement();

		if (p_coordinates == null || p_type == null || p_name == null)
			throw new AircraftFactoryException("Parameters failed");

		switch (p_type) {
			case "Helicopter":
				return new Helicopter(id, p_name, p_coordinates);
			case "Balloon":
				return new Balloon(id, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(id, p_name, p_coordinates);
			default:
				throw new AircraftFactoryException("Unkown aircraft type");
		}
	}

	public Flyable newAircraft(String p_type, String p_name, int longitude, int latitude, int height) throws AircraftFactoryException {
		long id = idGenerator.getAndIncrement();
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (p_type == null || p_name == null)
			throw new AircraftFactoryException("Parameters failed");

		switch (p_type) {
			case "Helicopter":
				return new Helicopter(id, p_name, coordinates);
			case "Balloon":
				return new Balloon(id, p_name, coordinates);
			case "JetPlane":
				return new JetPlane(id, p_name, coordinates);
			default:
				throw new AircraftFactoryException("Unkown aircraft type");
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
