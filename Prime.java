
// call this program Prime.java

class Prime {

  public static void main(String args[]) {

    int number_tested;
    boolean is_it_prime;

    number_tested = 2;

        while ( number_tested < 20)
	{

    // assume the number is prime
    // until we prove otherwise
         is_it_prime = true;



    for(int i=2; i <= (number_tested / 2); i++)  // now test the number
    {

      {

        is_it_prime = ((number_tested % i) == 0) ? false : true;

      if (!is_it_prime) break;  //
     } //if

    }		// end for

    if(is_it_prime) System.out.println(" the number is prime " + number_tested);

    else System.out.println(" \t\t\t the number is not prime " + number_tested );
        number_tested++;

  }// end while

}// end main

}// Prime

