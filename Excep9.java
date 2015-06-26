// save this program as Excep9.java

class Excep9 {

  public static void main(String args[]) {

    int result = 5;
    int test = 0;
    int list[] = new int[3];
    int i;

    for(i=0;i<5;++i) 

    try{

     // testing for the even numbers !!!!
   // list[6] = 100;
    // System.out.println(" the value of list[6] is " + list[6]);
    
	result = (i %2 ==0) ? 99 : result/test;

    System.out.println(" the value of result is " + result);
    System.out.println();
    }//try block

     catch(ArithmeticException errmsg)
    {

    // this will be more specific than the first catch statement on line 14
    System.out.println("Division by zero is undefined !!!" + errmsg);
    // handle the exception and assign result a value !!!
    result = -451;
    System.out.println(" \t\t\t   the value of result is " + result);
	System.out.println();
	 
    }//catch

     catch(Exception errmsg)
    {

    System.out.println("This is the catch-all the value of i is " + i +  " \n   "   +errmsg);
    System.out.println();

    }//catch


  }// main

}// class Excep9
