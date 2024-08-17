public class Vector {
	double[] components;	

	public Vector(double... data) {
		//Populate vector instance
		components = data;
	}
	public int length(){
		return components.length;
	}

	//Display vector in the form < ... >
	public void display(){
		System.out.print("< ");
		for (double component : components){
			System.out.print(component + " ");
		}	
		System.out.println(">");
	}	
	public double magnitude(){
		int l = this.length();
		//Sum Squares of vectors components
		double sum = 0;
		for (int i = 0; i < l; i++){
			sum += (components[i] * components[i]);
		}
		//||v|| = sqrt(sum of the squares of components)
		return Math.sqrt(sum);
	}
	public Vector unit(){
		//u = v / ||v||
		return this.mul(1.0 / this.magnitude());
	}
	//Check if two vectors are of the same dimension
	private void checkSameDim(Vector other){
		if (this.length() != other.length()){
			throw new IllegalArgumentException("Vectors must have same dimension!");
		}
	}
	//Checks if the Vectors are equivalent (components)
	public boolean isEqual(Vector other){
		checkSameDim(other);
		
		//Check if their contents are the same
		int l = this.length();
		for (int i = 0; i < l; i++) {
			if (this.components[i] != other.components[i]){
				return false;
			}
		}
		return true;
	}

	//Checks for linear independence of two vectors
	public boolean isLinIndep(Vector other){
		//if their unit vectors are not the same => linearly independent
		return !this.unit().isEqual(other.unit());
	}

	//Vector-Scalar Multiplication
	public Vector mul(double scalar){
		int l = this.length();
		double[] result = new double[l];

		//Scale vector
		for (int i = 0; i < l; i++){
			result[i] = scalar * components[i];
		}
		return new Vector(result);
	}
	//Vector addition
	public Vector add(Vector other){
		checkSameDim(other);
		
		//Sum components
		int l = this.length();
		double[] result = new double[l];
		for (int i = 0; i < l; i++){
			result[i] = this.components[i] + other.components[i];
		}
		//return new vector
		return new Vector(result);
	}
	//Vector Subtraction in terms of addition 
	public Vector sub(Vector other) {
		checkSameDim(other);

		//V - W = V + (-W)
		return this.add(other.mul(-1));
	}
	//Calculate the dot product
	public double dot(Vector other){
		checkSameDim(other);

		int l = this.length();
		double sum = 0;
		for (int i = 0; i < l; i++){
			sum += this.components[i] * other.components[i];
		}
		return sum;
	}
	//Check for orthogonality
	public boolean isOrtho(Vector other){
		return this.dot(other) == 0;
	}

	//The cross product of two vectors (anti-commutative)
	//Only for three-dimensions cuz wtf!
	/*
	public Vector cross(Vector other){
	}
	*/
	
}
