package aircraft;

import bonus.AircraftConditionException;
import simulator.SimulationLogger;

public class Balloon extends Aircraft {
	public Balloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() throws AircraftConditionException {
		String weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "SUN"	-> coordinates.changeCoordinates(2, 0, 4);
			case "RAIN"	-> coordinates.changeCoordinates(0, 0, -5);
			case "FOG"	-> coordinates.changeCoordinates(0, 0, -3);
			case "SNOW"	-> coordinates.changeCoordinates(0, 0, -15);
			default		-> throw new AircraftConditionException("Unkown weather");
		}

		SimulationLogger.newLog(this.printInfos() + ": " + AircraftMessages.BALLOON.getMessage(weather));

		super.updateConditions();
	}
}
