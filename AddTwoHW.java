/**************************************************
	AddTwoHW.java
	Julie Stoller
	Java Programming - Tues. 8-10pm, Burlington
	Fall 2000
 
***************************************************/

class AddTwoHW {

  public static void main(String args[]) {

    int a,b; // this declares 2 variables of type integer
    
    int sum=0;// this declares an integer named sum and
    // sets its initial value to zero

    double c,d; //this declares 2 variables of type double

    double sumd=0.0; // this declares a double named sumd and sets initial value to zero

    a=5;  // a now has the value 5

    b=10; // b now has the value 10

    c=5.5; // c now has the value 5.5

    d=10.4; // d now has the value 10.4

    sum = a + b; // the value of sum is now 15

    System.out.println("This is the sum of a and b " + sum);

    sum =sum /2;  // note that the value of sum is 7 and not 7.5
    // you only get the integer portion of the number.

    System.out.print("The average of the two numbers is ");
    // note the this print statement has the ln left off !!!!

    System.out.println(sum); // the value of sum will be printed on the same line.
    // and the cursor will then move to the next line.

    sumd = c + d; // the value of sumd is now 15.9

    System.out.println("This is the sum of c and d: " + sumd); 

    sumd = sumd / 2; //should now get a double back

    System.out.print("The average of the two doubles is: ");

    System.out.println(sumd); // this should be printed on the same line as above
  }//main
}//Ex2

