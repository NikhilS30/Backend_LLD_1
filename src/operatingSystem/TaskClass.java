package operatingSystem;

public class TaskClass implements Runnable{

	public int numberToprint;
	public TaskClass(int i) {
		numberToprint=i;
	}

	@Override
	public void run() {
		System.out.println("print number "+numberToprint+" thread is executed by : "+ Thread.currentThread().getName());
	}
	
}
