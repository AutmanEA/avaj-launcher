import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import bonus.ParsingException;
import bonus.SimulationException;
import bonus.SimulationLoggerException;
import simulator.SimulationLogger;
import simulator.Simulation;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Program takes exactly one scenario argument");
			return;
		}
		File	input = new File(args[0]);

		try (Scanner reader = new Scanner(input)) {
			ArrayList<String> simulationParameters = Parsing.fileParser(reader);

			Simulation simulation = new Simulation(simulationParameters);

			simulation.run();
			SimulationLogger.extractLogs();
		} catch (ParsingException pe) {
			System.err.println("PARSING_ERROR: " + pe);
		} catch (SimulationException se) {
			System.err.println("SIMULATION_ERROR: " + se);
		} catch (SimulationLoggerException sle) {
			System.err.println("LOGGER_ERROR: " + sle);
		} catch (FileNotFoundException fnfe) {
			System.err.println("READER_ERROR: " + fnfe);
		} catch (Exception e) {
			System.err.println("UNKNOWN_ERROR: " + e);
		}
	}
}
