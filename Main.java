import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Program takes exactly one scenario argument");
			return;
		}
		File input = new File(args[0]);
		File output = new File("simulation.txt");
		try (Scanner reader = new Scanner(input)) {
			if (!output.createNewFile()) {
				System.err.println("File already exists.");
				return;
			}
			while (reader.hasNext()) {
				String line = reader.nextLine();
				// TODO: parser
				System.out.println(line);
			}

		} catch (IOException e) {
			System.err.println("An error occured.");
		}
	}
}
