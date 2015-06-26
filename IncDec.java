// save this as IncDec.java

class IncDec {

  public static void main(String args[]) {

    int i = 5;

    int sum = 0;

//Now we will Echoprint
    System.out.println(" i is " + i + " sum is " + sum);

    sum = sum + i++;

    System.out.println(" i is " + i + " sum is " + sum);

    // let's return i to 5 and sum to 0

    i = 5;
    sum = 0;
    // now watch the difference


    sum = sum + ++i;

    System.out.println(" i is " + i + " sum is " + sum);

    // do you see the difference in the output


    // let's once again return i to 5  and sum to 0

    i = 5;
    sum = 0;

    // now watch the difference


    sum = sum + --i;

    System.out.println(" i is " + i + " sum is " + sum);


    // one more time 

    i = 5;
    sum = 0;

    // last time !!!  watch the difference


    sum = sum + i--;

    System.out.println(" i is " + i + " sum is " + sum);

    i = 5;
    sum = 0;
	 System.out.println("\n here's the big ending!!!! sum is " + (sum = sum + i++));
		
i = 5;
		System.out.println("\n the value of i is " + ++i);
  }//main

}//IncDec






