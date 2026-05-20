package simulator;
import java.io.File;
import java.util.ArrayList;

import aircraft.AircraftFactory;
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

				var newAircraft = factory.newAircraft(p_type, p_name, lon, lat, height);
				tower.register(newAircraft);
			}
		}
	}

	public void run() {

	}

	public File out() {
		return new File("NO FILE YET");
	}
}
