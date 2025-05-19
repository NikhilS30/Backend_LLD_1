package AddedSubtractorLock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
	public Count count;
	private Lock lock;
	
	Subtractor(Count count,Lock lock){
		this.count = count;
		this.lock = lock;
	}


	@Override
	public void run() {
		for(int i=1;i<=1000000;i++) {
			lock.lock();
			count.value -=i;
			lock.unlock();
		}
	}

}
