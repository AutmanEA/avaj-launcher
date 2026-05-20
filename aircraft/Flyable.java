package aircraft;

import weather.WeatherTower;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower p_tower);
	public String printInfos();
}
