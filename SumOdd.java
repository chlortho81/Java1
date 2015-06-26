


// save this file as SumOdd.java

class SumOdd {

  public static void main(String args[]) {

   int n;
   int sumeven = 0;
   int sumodd = 0;

   boolean odd;

   for(n=0;n<=50;++n)
   {

   odd = ( n % 2 == 1) ? true: false;
if (odd) sumodd += n; else sumeven += n;
  // if ( n % 2 == 1) sumodd += n;

 //  if (! (n % 2 == 1)) sumeven += n;

   }//for


    System.out.println("the sum of the odd numbers from 0 to 50 is " + sumodd);

    System.out.println("the sum of the even numbers from 0 to 50 is " + sumeven);


    System.out.print("the sum of the even numbers is greater ");
    System.out.print("than the sum of the oddnumbers is " + (sumeven > sumodd));
    System.out.println();


  }//main

}//SumOdd
