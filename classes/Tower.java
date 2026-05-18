package classes;

import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
	}
	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
	}
	protected void conditionChanged() {
		/* */
	}
}
