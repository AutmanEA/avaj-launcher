package aircraft;

import bonus.AircraftConditionException;
import weather.WeatherTower;

public interface Flyable {
	public void updateConditions() throws AircraftConditionException;
	public void registerTower(WeatherTower p_tower);
	public String printInfos();
}
