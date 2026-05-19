package weather;

import aircraft.Coordinates;

public class WeatherProvider {

	private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	public String getCurrentWeather(Coordinates p_coordinates) {
		int weatherIndex = (p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude()) % 3;
		return weather[weatherIndex];
	}

	// SINGLETON
	private static volatile WeatherProvider _instance;

	private WeatherProvider() {}

	public static WeatherProvider getInstance() {
		if (_instance != null)
			return _instance;
		synchronized(WeatherProvider.class) {
			if (_instance == null) {
				_instance = new WeatherProvider();
			}
		}
		return _instance;
	}

}
