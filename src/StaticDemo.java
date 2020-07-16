/*
 * Before creating any object, you first need to load the class. 
 * Object is created in the heap memory
 * There is a special memory in JVM where you load all your classes. That memory is called as a class loader memory
 * To want certain variables to be object specific, you can make them as a static variable.
 * So, when you make a variable static, it will not be for any particular object, it will 
 * be for a class. Here string ceo will go to the class loader memory now and not heap memory
 * To access a static variable we do not need objects and that's why we can also make a method static
 * STATIC VARIABLES ARE SAME FOR ALL THE OBJECTS
 * NON-STATIC VARIABLES ARE DIFFERENT FOR ALL THE OBJECTS
 * CANNOT USE NON-STATIC VARIABLES IN STATIC BLOCK
 */

class Emp {
	int eid;
	int salary;
	static String ceo;
	
	static {
		System.out.println("In Static Block 3");
	}
	
	// Just to initialize static variables, we have static block
	// Static block is a special block in java 
	//Use static block to initialize static variables
	// Static block gets executed when u load a class
	// Class will load only once
	//Even though u write the static block after the constructor it will be executed first
	// If you have multiple static block in a class, then it will follow the sequence.
	static {
		ceo = "Larry";
		System.out.println("In Static Block 1");
	}
	
	//Use constructor to initialize non-statoc variables
	//Constructors gets executed when u create an object
	public Emp() {
		eid = 1;
		salary = 3000;
		System.out.println("In constructor");
	}
	
	
	public void show() {
		System.out.println("Eid- " + eid + ": Salary- " + salary + ": CEO- " + ceo);
	}
	
	static {
		System.out.println("In Static Block 2");
	}
}


public class StaticDemo {
	 
//	int i = 9;  Non-static variable
	public static void main(String[] args) {
		Emp navin = new Emp();
		// i = 0; Error! Cannot make a static reference to a non-static variable
		navin.eid = 8;
		navin.salary = 4000;
		navin.ceo = "Mahesh"; // Emp.ceo = "Mahesh"
  		
		Emp rahul = new Emp();
		rahul.eid = 9;
		rahul.salary = 5000;
		rahul.ceo = "Mahesh"; // Emp.ceo = "Mahesh"
		
		Emp.ceo = "Nikita";
		
		navin.show();
		rahul.show();
	}

}
