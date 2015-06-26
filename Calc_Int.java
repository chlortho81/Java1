 // save this file as Calc_Int.java

class Calc_Int {

  public static void main(String args[]) {

   // these are the variables
      double principal;  
      double  rate;
      float time;
      double amount;

  // now let's assign starting values to the variables

      principal=55000.00;
      rate=.0565;
      time=2.5f;

  // now let's calculate the amount of interset that will be generated
      amount  =  principal * rate * time;

    //let's output the final amount
    System.out.printf(" with the amount of %.2f",principal );
    System.out.println(" dollars placed in the bank for " +  time);
    System.out.println(  " years at a rate of "+ (rate * 100)   );
    System.out.println(" percent, the total value is " + amount);

      }//main
}// Calc_Int



 
 
 
 
 
 
 
  
