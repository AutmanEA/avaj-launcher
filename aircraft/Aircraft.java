package aircraft;

import bonus.AircraftConditionException;
import simulator.SimulationLogger;
import weather.WeatherTower;

public class Aircraft implements Flyable {
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	protected WeatherTower	weatherTower;

	public void updateConditions() throws AircraftConditionException {
		if (coordinates.getHeight() <= 0) {
			SimulationLogger.newLog(this.printInfos() + " landing.");
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower p_tower) {
		weatherTower = p_tower;
	}

	public final String printInfos() {
		String type = getClass().getSimpleName();

		return type + "#" + name + "(" + id + ")";
	}

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		id = p_id;
		name = p_name;
		coordinates = p_coordinates;
	}
}
