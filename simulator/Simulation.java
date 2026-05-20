package simulator;
import java.io.File;
import java.util.ArrayList;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import weather.WeatherProvider;
import weather.WeatherTower;

public class Simulation {
	private int simCount = 0;
	private AircraftFactory factory = AircraftFactory.getInstance();
	private WeatherProvider provider = WeatherProvider.getInstance();
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
				System.out.println(newAircraft.printInfos());
				tower.register(newAircraft);
			}
		}
	}

	public void run() {
		ArrayList<Flyable> flyables = new ArrayList<>(tower.getObservers());

		while (simCount > 0) {


			for (var aircraft: flyables) {
				aircraft.updateConditions();
			}


			simCount--;
		}




	}
}
