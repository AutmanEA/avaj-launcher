import java.util.ArrayList;
import java.util.List;

public class Main {
	private static List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {

			// Items keep being added but never removed
			list.add("Item " + i);
		}
		System.out.println("Finished adding items!");
	}
}
