package aircraft;

import simulator.SimulationLogger;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		switch (weatherTower.getWeather(coordinates)) {
			case "SUN":
				coordinates.changeCoordinates(0, 10, 2);
				SimulationLogger.newLog(this.printInfos() + ": JETPLANE SUN MSG");
				break;
			case "RAIN":
				coordinates.changeCoordinates(0, 5, 0);
				SimulationLogger.newLog(this.printInfos() + ": JETPLANE RAIN MSG");
				break;
			case "FOG":
				coordinates.changeCoordinates(0, 1, 0);
				SimulationLogger.newLog(this.printInfos() + ": JETPLANE FOG MSG");
				break;
			case "SNOW":
				coordinates.changeCoordinates(0, 0, -7);
				SimulationLogger.newLog(this.printInfos() + ": JETPLANE SNOW MSG");
				break;
			default:
				break;
		}

		super.updateConditions();
	}
}
