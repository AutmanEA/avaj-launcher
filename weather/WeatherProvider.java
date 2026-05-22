package weather;

import aircraft.Coordinates;

public class WeatherProvider {

	private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	public String getCurrentWeather(Coordinates p_coordinates) {
		int weatherIndex = (p_coordinates.getHeight() * 83 + p_coordinates.getLatitude() * 41 + p_coordinates.getLongitude() * 17);
		return weather[Math.abs(weatherIndex) % 4];
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
