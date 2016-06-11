import java.util.*;

/**
 * nextLine reads a string
 * nextInt reads an integer
 * nextDouble reads a double
 * nextChar reads a character
 */
public class In {

	private static final Scanner scanner = new Scanner(System.in);
	private In() {}

	public static String nextLine() {
		return scanner.nextLine();
	}

	public static int nextInt() {
		int value = scanner.nextInt();
		scanner.nextLine(); // read the "\n" as well
		return value;
	}

	public static double nextDouble() {
		double value = scanner.nextDouble();
		scanner.nextLine();
		return value;
	}

	public static char nextChar() {
		return scanner.nextLine().charAt(0);
	}
}
