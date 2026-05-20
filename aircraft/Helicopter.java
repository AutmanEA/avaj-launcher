package aircraft;

import simulator.SimulationLogger;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		switch (weatherTower.getWeather(coordinates)) {
			case "SUN":
				coordinates.changeCoordinates(10, 0, 2);
				SimulationLogger.newLog(this.printInfos() + ": HELICOPTER SUN MSG");
				break;
			case "RAIN":
				coordinates.changeCoordinates(5, 0, 0);
				SimulationLogger.newLog(this.printInfos() + ": HELICOPTER RAIN MSG");
				break;
			case "FOG":
				coordinates.changeCoordinates(1, 0, 0);
				SimulationLogger.newLog(this.printInfos() + ": HELICOPTER FOG MSG");
				break;
			case "SNOW":
				coordinates.changeCoordinates(0, 0, -12);
				SimulationLogger.newLog(this.printInfos() + ": HELICOPTER SNOW MSG");
				break;
			default:
				break;
		}

		super.updateConditions();
	}
}
