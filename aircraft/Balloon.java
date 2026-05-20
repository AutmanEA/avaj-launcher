package aircraft;

public class Balloon extends Aircraft {
	public Balloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		switch (weatherTower.getWeather(coordinates)) {
			case "SUN":
				coordinates.changeCoordinates(2, 0, 4);
				break;
			case "RAIN":
				coordinates.changeCoordinates(0, 0, -5);
				break;
			case "FOG":
				coordinates.changeCoordinates(0, 0, -3);
				break;
			case "SNOW":
				coordinates.changeCoordinates(0, 0, -15);
				break;
			default:
				break;
		}
	}
}
