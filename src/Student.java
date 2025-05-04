
/*
 *Intro to oops 
 */

public class Student {

	int age = 10;
	String name = "Nikhil";

	private void printDetails() {
		System.out.println(name + " age is " + age + " and he is printing");
	}

	public static void main(String[] args) {
		Student st = new Student();
		st.printDetails();
		Student st1 = st;
		System.out.println(st);
		System.out.println(st1);
		st1.age=20;
		st.printDetails();
	}
}