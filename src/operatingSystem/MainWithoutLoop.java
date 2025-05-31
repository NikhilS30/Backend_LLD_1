package operatingSystem;

public class MainWithoutLoop {
	public static void main(String[] args) {
		int i =1;
		NumberPrinter taskClass = new NumberPrinter(i);
		Thread thread = new Thread(taskClass);
		thread.start();
		
		System.out.println("print number "+i+" thread is executed by : "+ Thread.currentThread().getName());
	}

}


//print number 1 thread is executed by : Thread-0
//print number 1 thread is executed by : main

//print number 1 thread is executed by : main
//print number 1 thread is executed by : Thread-0
