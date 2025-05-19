package AddedSubtractor;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		Count count = new Count(0);
		
		Adder adder = new Adder(count);
//		Subtractor subtractor = new Subtractor(count);
		
		Thread thread1 = new Thread(adder);
		Thread thread2 = new Thread(adder);
//		Thread thread2 = new Thread(subtractor);
		thread1.start();
//		thread1.join();   // if we add this,then this will make sure first t1 executed then t2
		thread2.start();
//		thread2.join();
		Thread.sleep(50000);
		System.out.println(count.value);
	}

}
