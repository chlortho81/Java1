// Aaron Whittle's Boolean Example

class BoolEx {

	public static void main(String[] args) {
		
		Boolean flag; //this is how you declare a boolean variable

		flag = true; // this is how to assign boolean

		System.out.println("flag is " + flag);

		flag = false;
		System.out.println("flag is " + flag);

		if(flag) System.out.println("flag is true.");

		flag = false;
		if(!flag) System.out.println("flag is false.");

		flag = !flag;
		System.out.println("flag is false."); // run and tell me

	}
}