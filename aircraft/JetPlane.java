package aircraft;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		switch (weatherTower.getWeather(coordinates)) {
			case "SUN":
				coordinates.changeCoordinates(0, 10, 2);
				break;
			case "RAIN":
				coordinates.changeCoordinates(0, 5, 0);
				break;
			case "FOG":
				coordinates.changeCoordinates(0, 1, 0);
				break;
			case "SNOW":
				coordinates.changeCoordinates(0, 0, -7);
				break;
			default:
				break;
		}
	}
}
