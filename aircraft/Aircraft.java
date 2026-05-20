package aircraft;

import weather.WeatherTower;

public class Aircraft implements Flyable {
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	protected WeatherTower	weatherTower;

	public void updateConditions() {

	}

	public void registerTower(WeatherTower p_tower) {

	}

	public String printInfos() {
		return "Aircraft#" + name + "(" + id + ")";
	}

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {

	}
}
