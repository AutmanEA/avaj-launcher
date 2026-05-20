package simulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SimulationLogger {

	private static ArrayList<String> logs = new ArrayList<String>();

	public static void newLog(String log) {
		logs.add(log);
	}

	public static File extractLogs() {
		File output = new File("simulation.txt");

		try (FileWriter writer = new FileWriter(output)) {
			writer.write("-- START --\n");
			for (String log : logs) {
				writer.write(log + "\n");
			}
			writer.write("-- END --\n");

		} catch (IOException e) {
			System.err.println("ERR: Logger can't write in file.");
		}

		return output;
	}

	// SINGLETON
	private static volatile SimulationLogger _instance;

	private SimulationLogger() {}

	public static SimulationLogger getInstance() {
		if (_instance != null)
			return _instance;
		synchronized(SimulationLogger.class) {
			if (_instance == null) {
				_instance = new SimulationLogger();
			}
		}
		return _instance;
	}
}
