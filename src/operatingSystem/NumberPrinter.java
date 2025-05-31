package operatingSystem;

public class NumberPrinter implements Runnable{

	public int numberToprint;
	public NumberPrinter(int i) {
		numberToprint=i;
	}

	@Override
	public void run() {
		System.out.println("print number "+numberToprint+" thread is executed by : "+ Thread.currentThread().getName());
	}
	
}
