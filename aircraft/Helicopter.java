package aircraft;

import bonus.AircraftConditionException;
import simulator.SimulationLogger;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() throws AircraftConditionException {
		String weather = weatherTower.getWeather(coordinates);

		switch (weather) {
			case "SUN"	-> coordinates.changeCoordinates(10, 0, 2);
			case "RAIN"	-> coordinates.changeCoordinates(5, 0, 0);
			case "FOG"	-> coordinates.changeCoordinates(1, 0, 0);
			case "SNOW"	-> coordinates.changeCoordinates(0, 0, -12);
			default		-> throw new AircraftConditionException("Unkown weather");
		}

		SimulationLogger.newLog(this.printInfos() + ": " + AircraftMessages.HELICOPTER.getMessage(weather));

		super.updateConditions();
	}
}
