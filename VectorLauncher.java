import java.util.Scanner;

public class VectorLauncher {
	public static void testUnit(Vector v){

		System.out.println("Let Vector:");
		v.display();
		System.out.println("The unit vector of the vector is: ");
		v.unit().display();
		System.out.println("---------------------------");
	}
	public static void testLinIndep(Vector v, Vector w){
		testUnit(v);
		testUnit(w);
		
		System.out.println("Are V and W the same?: " + w.isEqual(v));

		if (v.isLinIndep(w)){
			System.out.println("Vectors V and W are linearly independent");
		} else {
			System.out.println("V and W are dependent");
		}
		System.out.println("---------------------------");
	}
	public static void testIsEqual(Vector v, Vector w){
		System.out.println("Let Vector v: ");
		v.display();
		System.out.println("Let Vector w: ");
		w.display();
		
		if (v.isEqual(w)){
			System.out.println("Vectors v and w are the same");
		} else {
			System.out.println("Vectors v and w are not the same");
		}

		System.out.println("---------------------------");
	}
	public static void main(String[] args){

		System.out.println("< 


		
		//Create set of vectors

		
		//Now what??? 


		
		//Vector test
		Vector v = new Vector(2,3,4);	
		Vector w = v.mul(2).add(new Vector(new double[]{3,4,5}));

		//Scalar multiple of v
		Vector v2 = v.mul(2);
		
		testIsEqual(v,w);
		testLinIndep(v,w);

		testIsEqual(v, v2);
		testLinIndep(v, v2);
	}

}




