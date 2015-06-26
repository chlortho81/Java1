// call this file Do_While_Sum.java

class WhileSum {

  public static void main(String args[]) {

    int i=0;

    int sum = 0;
 while ( i <= 5)
    {
   
   sum+=i;

   // sum = sum + i;  // sum +=i;  works just as well !!!!
    ++i; // i++ works just as well !!!
    


}//while
 System.out.println(" the sum of the numbers from 1 to 5 is " + sum);
  }//main

}// Do_While_Sum

