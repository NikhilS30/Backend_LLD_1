package operatingSystem;

public class MainClass {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			NumberPrinter taskClass = new NumberPrinter(i);
			Thread thread = new Thread(taskClass);
			thread.start();
		}

	}
}
