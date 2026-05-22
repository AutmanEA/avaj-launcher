package simulator;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import bonus.AircraftFactoryException;
import bonus.SimulationException;
import bonus.TowerConditionException;
import weather.WeatherTower;

public class Simulation {
	private final int MAX_HEIGHT = 100;

	private int simCount = -1;
	private AircraftFactory factory = AircraftFactory.getInstance();
	private WeatherTower tower = new WeatherTower();

	public Simulation(ArrayList<String> parameters) throws SimulationException {
		for (var param : parameters) {
			if (simCount == -1) simCount = Integer.parseInt(param);
			else {
				try (Scanner scanner = new Scanner(param)) {
					String p_type = scanner.next();
					String p_name = scanner.next();
					int lon = scanner.nextInt();
					int lat = scanner.nextInt();
					int height = scanner.nextInt();

					if (height > MAX_HEIGHT)
						height = MAX_HEIGHT;

					Flyable newAircraft = factory.newAircraft(p_type, p_name, lon, lat, height);
					tower.register(newAircraft);
					newAircraft.registerTower(tower);
				} catch (NoSuchElementException nse) {
					throw new SimulationException("Scanner failed");
				} catch (AircraftFactoryException afe) {
					throw new SimulationException("Aircraft Factory failed : " + afe);
				}

			}
		}
	}

	public void run() throws SimulationException {
		int count = 1;

		try {
			while (count <= simCount) {
				SimulationLogger.newLog("\n-- STEP " + count + " --\n");
				tower.changeWeather();
				count++;
			}
		} catch (TowerConditionException tce) {
			throw new SimulationException("Tower failure :" + tce);
		}
	}
}
