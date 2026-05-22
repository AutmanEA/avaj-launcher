package weather;

import java.util.ArrayList;

import aircraft.Flyable;
import bonus.AircraftConditionException;
import bonus.TowerConditionException;
import simulator.SimulationLogger;

public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
		SimulationLogger.newLog("Tower says: " + p_flyable.printInfos() + " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
		SimulationLogger.newLog("Tower says: " + p_flyable.printInfos() + " unregistered to weather tower.");
	}

	protected void conditionChanged() throws TowerConditionException {
		var observersCopy = new ArrayList<>(observers);

		try {
			for (var aircraft : observersCopy) {
				aircraft.updateConditions();
			}
		} catch (AircraftConditionException ace) {
			throw new TowerConditionException("Tower detected aircraft condition error: " + ace);
		}
	}
}
