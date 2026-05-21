import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bonus.ParsingException;

public class Parsing {

	public static ArrayList<String> fileParser(Scanner reader) throws ParsingException {
		ArrayList<String> parameters = new ArrayList<String>();

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			if (parameters.isEmpty()) {
				try {
					int simNumber = Integer.parseInt(line);

					if (simNumber < 0) throw new ParsingException("Line 1 number must be >= 0");
					parameters.add(line);
				} catch (NumberFormatException nfe) {
					throw new ParsingException("Line 1 not a number");
				}
			} else {
				String	regex = "^[a-zA-Z0-9_-]+\\s[a-zA-Z0-9_-]+\\s(\\d+)\\s(\\d+)\\s(\\d+)$";

				Pattern	pattern = Pattern.compile(regex);
				Matcher	matcher = pattern.matcher(line);

				if (!matcher.matches()) throw new ParsingException("Wrong aircraft line format");

				try {
					int lon = Integer.parseInt(matcher.group(1));
					int lat = Integer.parseInt(matcher.group(2));
					int height = Integer.parseInt(matcher.group(3));

					if ((lon < 0) || (lat < 0) || (height < 0))
						throw new ParsingException("Coordinates must be positive numbers");
				} catch (NumberFormatException nfe) {
					throw new ParsingException("Coordinates must be integers");
				}
				parameters.add(line);
			}
		}
		return parameters;
	}

}
