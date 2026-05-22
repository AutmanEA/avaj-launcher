package aircraft;

import bonus.AircraftConditionException;
import simulator.SimulationLogger;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() throws AircraftConditionException {
		String weather = weatherTower.getWeather(coordinates);

		switch (weather) {
			case "SUN"	-> coordinates.changeCoordinates(0, 10, 2);
			case "RAIN"	-> coordinates.changeCoordinates(0, 5, 0);
			case "FOG"	-> coordinates.changeCoordinates(0, 1, 0);
			case "SNOW"	-> coordinates.changeCoordinates(0, 0, -7);
			default		-> throw new AircraftConditionException("Unkown weather");
		}

		SimulationLogger.newLog(this.printInfos() + ": " + AircraftMessages.JETPLANE.getMessage(weather));

		super.updateConditions();
	}
}
