package simulator;
import java.util.ArrayList;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import weather.WeatherTower;

public class Simulation {
	private int simCount = 0;
	private AircraftFactory factory = AircraftFactory.getInstance();
	private WeatherTower tower = new WeatherTower();

	public Simulation(ArrayList<String> parameters) {
		for (var param : parameters) {
			if (simCount == 0) simCount = Integer.parseInt(param);
			else {
				String[] paramSplit = param.trim().split("\\s+");
				String p_type = paramSplit[0];
				String p_name = paramSplit[1];
				int lon = Integer.parseInt(paramSplit[2]);
				int lat = Integer.parseInt(paramSplit[3]);
				int height = Integer.parseInt(paramSplit[4]);

				if (height > 100)
					height = 100;

				Flyable newAircraft = factory.newAircraft(p_type, p_name, lon, lat, height);
				tower.register(newAircraft);
				newAircraft.registerTower(tower);
			}
		}
	}

	public void run() {
		int count = 1;

		while (count <= simCount) {
			SimulationLogger.newLog("\n-- STEP " + count + " --\n");
			tower.changeWeather();
			count++;
		}
	}
}
