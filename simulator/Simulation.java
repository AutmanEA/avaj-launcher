package simulator;
import java.util.ArrayList;
import java.util.Scanner;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import weather.WeatherTower;

public class Simulation {
	private final int MAX_HEIGHT = 100;

	private int simCount = 0;
	private AircraftFactory factory = AircraftFactory.getInstance();
	private WeatherTower tower = new WeatherTower();

	public Simulation(ArrayList<String> parameters) {
		for (var param : parameters) {
			if (simCount == 0) simCount = Integer.parseInt(param);
			else {
				Scanner scanner = new Scanner(param);
				String p_type = scanner.next();
				String p_name = scanner.next();
				int lon = scanner.nextInt();
				int lat = scanner.nextInt();
				int height = scanner.nextInt();
				scanner.close();

				if (height > MAX_HEIGHT)
					height = MAX_HEIGHT;

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
