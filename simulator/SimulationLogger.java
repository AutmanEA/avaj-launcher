package simulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import bonus.SimulationLoggerException;

public class SimulationLogger {

	private static ArrayList<String> logs = new ArrayList<String>();

	public static void newLog(String log) {
		logs.add(log);
	}

	public static File extractLogs() throws SimulationLoggerException {
		File output = new File("simulation.txt");

		try (FileWriter writer = new FileWriter(output)) {
			writer.write("-- START --\n\n");
			for (String log : logs) {
				writer.write(log + "\n");
			}
			writer.write("\n-- END --\n");

		} catch (IOException e) {
			throw new SimulationLoggerException("Logger can't write in file");
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
