
public class Main {

	public static void main(String[] args) {
		Student st = new Student();
		st.printDetails();
		Student st1 = st;
		System.out.println(st);
		System.out.println(st1);
		st1.age = 20;
		st.printDetails();
	}
	// abstract vs interface ---> diamond problem ?
	// string immutable
	// p -> refernce
	// st -> stack memory - > heap memory
}
