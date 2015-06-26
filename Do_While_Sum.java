// call this file Do_While_Sum.java

class Do_While_Sum {

  public static void main(String args[]) {

    int i=0;

    int sum = 0;

    do{
   
   sum += (i % 2==0) ? i : 0 ;

   // sum = sum + i;  // sum +=i;  works just as well !!!!
    ++i; // i++ works just as well !!!
    } while ( i <= 50);

  System.out.println(" the sum of the numbers from 1 to 50 is " + sum);


  }//main

}// Do_While_Sum

