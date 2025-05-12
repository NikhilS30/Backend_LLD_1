package operatingSystem;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("This thread is executed by :" + Thread.currentThread().getName());

		TaskClass taskClass = new TaskClass();
		Thread thread = new Thread(taskClass);
		thread.start();
		
		System.out.println("This thread is executed by :" + Thread.currentThread().getName());
	}
	
}
