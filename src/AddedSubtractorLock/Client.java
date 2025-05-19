package AddedSubtractorLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
	public static void main(String[] args) {
		Count count = new Count(0);
		
		Lock lock = new ReentrantLock();
		Adder adder = new Adder(count,lock);
		Subtractor subtractor = new Subtractor(count,lock);
		
		Thread thread1 = new Thread(adder);
		Thread thread2 = new Thread(subtractor);
		thread1.start();
		thread2.start();
		
		System.out.println(count.value);
	}

}
