package callable_and_future;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<Integer>{
	private int number;
	
	public CallableDemo(int i) {
		number = i;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println( number+ ":: " +Thread.currentThread().getName());
		return number;
	}

}
