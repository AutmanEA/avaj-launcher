package aircraft;

import weather.WeatherProvider;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		WeatherProvider provider = WeatherProvider.getInstance();

		switch (provider.getCurrentWeather(coordinates)) {
			case "SUN":
				break;
			case "RAIN":
				break;
			case "FOG":
				break;
			case "SNOW":
				break;
			default:
				break;
		}
	}
}
