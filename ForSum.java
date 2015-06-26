// call this file ForSum2.java

class ForSum {

  public static void main(String args[]) {

    int i;

    int sum = 0;

    for(i = 0; i<=5; ++i) {

 
          // sum = sum + i;
         sum += (i % 2 == 0)? i:0;
           

    }//for

  System.out.println(" the sum of the even numbers from 0 to 5 is " + sum);


  }//main

}// ForSum

