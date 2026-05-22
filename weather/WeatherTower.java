package weather;

import aircraft.Coordinates;
import bonus.TowerConditionException;

public class WeatherTower extends Tower {
	private WeatherProvider provider = WeatherProvider.getInstance();

	public String getWeather(Coordinates p_coordinates) {
		return provider.getCurrentWeather(p_coordinates);
	}

	public void changeWeather() throws TowerConditionException {
		conditionChanged();
	}
}
