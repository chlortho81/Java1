/**************************************************
	ForExHW.java
	Julie Stoller
	Java Programming - Tues. 8-10pm, Burlington
	Fall 2000
 
***************************************************/

class ForExHW {

public static void main(String agrs[]) 
{

	int i;
	int a = 35;

	for (i=0;i<10;++i)
		{
		System.out.print(a);
		System.out.print(" is: ");
		System.out.println((char)a); //this should print out # first
		a = a + 1;
		} 

	System.out.println();

	System.out.println("The Final Countdown...");
	
	System.out.println();

	for (i=10;i>=0;--i)
		{
 		System.out.print(i);
		System.out.print("....");
		}
	System.out.println();

	System.out.println();

	System.out.println("~ ~ ~ K   A   A   B   O   O   M   !    !   ! ~ ~ ~");  

}//main

}//ForEx

