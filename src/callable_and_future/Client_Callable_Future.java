package callable_and_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Client_Callable_Future {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int i=1;i<=100;i++) {
			CallableDemo callableDemo = new CallableDemo(i);
			executorService.submit(callableDemo);
			Future<Integer> submit = executorService.submit(callableDemo);
		}
		executorService.awaitTermination(1, TimeUnit.SECONDS); //this waits for a period of time for all task completion 
		executorService.shutdown(); //this will shutdown after all tasks are completed gracefully
		
	}
}
