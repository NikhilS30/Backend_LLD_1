package operatingSystem;

public class TaskClass implements Runnable{

	@Override
	public void run() {
		System.out.println("This thread is executed by : "+ Thread.currentThread().getName());
	}
}
