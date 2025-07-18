package operatingSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class executorServiceDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for (int i = 1; i <= 100; i++) {
			NumberPrinter taskClass = new NumberPrinter(i);
			executorService.execute(taskClass);
		}
		executorService.shutdown();
	}
}
