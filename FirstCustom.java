// Aaron Whittle's first custom program

class FirstCustom {

	public static void main(String[] args) {
		
		System.out.println("This may or may not do anything cool, at all, but I'm trying to just make it happen");

		int a,b,c,d,e; // declaring my variables and they are all integers

		int total = 0;

		a=4;
		b=9;
		c=11;
		d=3;
		e=3;

		int q;

		total = a+b+c+d+e;

		System.out.println("The total variables a,b,c,d,e is " + total);

		System.out.println("that's a bit too easy, though");

		total = total/3;

		System.out.print("the average of the total is ");
		System.out.println(total);

		if (total<=10) {
			System.out.println("The total is less than or equal to 10");
			
		}

		if (total<=15) {
			System.out.println("The total is less than or equal to 15");
			
		}

		System.out.println("moving forward, let's create a For statement with");
		System.out.println("an initializer, condition, and an increment");

		System.out.println("here it goes!");

		for (q=9;q>=0;--q) {

		System.out.println(q);
		}

		System.out.println("now lets see it backwards");

		for (q=0;q<=9;++q) {
			System.out.println(q);
		}		

		System.out.println("that's all I got");

	}
}