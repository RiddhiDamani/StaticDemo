class C {
	public int _i;
	public boolean _j;
	public C(int i, boolean j) {
		_i = i; // 22
		_j = j; // false
	}
	
	public boolean equals(Object that) {
		if(that == null || !(that instanceof C)) {
			return false;
		}
		else {
			C thatC = (C) this;
			return this._i == thatC._i && this._j == thatC._j;
		}
	}
}


public class EqualsDemo {

	public static void main(String[] args) {
		C c1 = new C(22, false);   //c1 = (22, false)     creates a new reference block and stores the values
		C c2 = c1;                   // c2 = (22, false)  pointing to same reference block on c1v- same object on the heap as c1
		C c3 = new C(22, false);    // c3 =  (22, false)  creates a new reference block and stores the values. c1 is not equal to c3.
		
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		System.out.println(c1 == c3);     // hence false ; == means reference comparison and not value comparison; 
										// we are instantiating 2 different objects on the heap; hence, it will not == each other.
		System.out.println(c1.equals(c3));   // but value is same -> so .equals checks the value and not reference location
											// we compare the values here using .equals

	}

}
