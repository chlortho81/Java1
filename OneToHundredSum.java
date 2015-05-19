/* Aaron Whittle week 2 assignment..  The examples have helped a lot, especially if there's a lot of
pseudo code
*/

class OneToHundredSum {

	public static void main(String args[])  {
		int start = 1;
		int sum = 0;
		while (start < 101) {
			sum += start;
			start++;
		}
		System.out.println(sum);

	}
}