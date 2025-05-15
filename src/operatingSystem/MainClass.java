package operatingSystem;

public class MainClass {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			TaskClass taskClass = new TaskClass(i);
			Thread thread = new Thread(taskClass);
			thread.start();
		}
	}
}
