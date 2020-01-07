package orderOfExec;

public class OrderOfExec {

	static int superInt = superIntMethod();

	static {
		System.out.println("Executing superclass static block");
	}
	
	static int superIntMethod(){
		System.out.println("Initializing superclass static variable superInt");
		return 1;
	}
	
	static int superInstanceIntMethod() {
		System.out.println("Initialzing superclass instance variable superInstanceInt");
		return 3;
	}
	
	@SuppressWarnings("unused")
	private int superInstanceInt=superInstanceIntMethod();
	
	OrderOfExec(){
		System.out.println("Running superclass constructor");
	}
	
	{
		System.out.println("Running superclass object initialization block");
	}
	public static void main(String[] args) {
		new MySubClass();

	}

}

class MySubClass extends OrderOfExec {
	static int subInt = subIntMethod();
	static int subIntMethod(){
		System.out.println("Initializing subclass static variable subInt");
		return 2;
	}
	
	static {
		System.out.println("Executing subclass static block");
	}

	
	static int subInstanceIntMethod() {
		System.out.println("Initialzing subclass instance variable subInstanceInt");
		return 3;
	}
	MySubClass(){
		System.out.println("Running subclass constructor");
	}
	{
		System.out.println("Running subclass object initialization block");
	}
	
	
	@SuppressWarnings("unused")
	private int subInstanceInt = subInstanceIntMethod();
		
}