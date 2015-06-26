class Divisible {
	public static void main(String args[]) {
		int[] divisors = { 7, 11, 13, 17 };
		int[] divisible = new int[divisors.length];
		
		for(int i = 1; i<=100000; i++) {
			for(int j = 0; j<divisors.length; j++) {
				if((i % divisors[j]) == 0) divisible[j] = i;
			}
		}
		
		for(int i = 0; i<divisors.length; i++) {
			System.out.println("The largest number divisible by " + divisors[i] + " is " + divisible[i] + ".");
		}
	}
}