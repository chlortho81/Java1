// Aaron Whittle ForEx.java

class ForEx {

	public static void main(String[] args) {
		
		
        double i;

		for (i=0.0;i<5.0;i = i + .5) 
            
			System.out.println(i);

		System.out.println("Now let us print it backwards");

		for (i=5.0;i>=0.0;i-=.5)
			System.out.println(i);
	}
}
