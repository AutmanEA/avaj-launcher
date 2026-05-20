import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import simulator.SimulationLogger;
import simulator.Simulation;

public class Main {
	private static ArrayList<String> parser(Scanner reader) {
		ArrayList<String> parameters = new ArrayList<String>();

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			if (parameters.isEmpty()) {
				int simNumber = Integer.parseInt(line);
				if (simNumber < 1) throw new NumberFormatException();
				parameters.add(line);
			} else {
				String regex = "^[a-zA-Z0-9_-]+\\s[a-zA-Z0-9_-]+\\s\\d+\\s\\d+\\s\\d+$";
				if (!line.matches(regex)) throw new IllegalArgumentException();
				String[] parseCoordinates = line.split("\\s");

				int lon = Integer.parseInt(parseCoordinates[2]);
				int lat = Integer.parseInt(parseCoordinates[3]);
				int height = Integer.parseInt(parseCoordinates[4]);

				if ((lon < 0) || (lat < 0) || (height < 0))
					throw new NumberFormatException();

				parameters.add(line);
			}
		}

		return parameters;
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Program takes exactly one scenario argument");
			return;
		}
		File	input = new File(args[0]);

		try (Scanner reader = new Scanner(input)) {
			ArrayList<String> simulationParameters = parser(reader);

			Simulation simulation = new Simulation(simulationParameters);

			simulation.run();
			SimulationLogger.extractLogs();
		} catch (IOException ioe) {
			System.err.println("ERR: Can't handle file.");
		} catch (NumberFormatException nfe) {
			System.err.println("ERR: First line must be an unsigned integer.");
		} catch (IllegalArgumentException iae) {
			System.err.println("ERR: Wrong scenario file content.");
		}
	}
}
