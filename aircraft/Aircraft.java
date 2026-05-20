package aircraft;

import weather.WeatherTower;

public abstract class Aircraft implements Flyable {
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	protected WeatherTower	weatherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower p_tower) {
		weatherTower = p_tower;
	}

	public String printInfos() {
		String type = getClass().getSimpleName();

		return type + "#" + name + "(" + id + ")";
	}

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		id = p_id;
		name = p_name;
		coordinates = p_coordinates;
	}
}
