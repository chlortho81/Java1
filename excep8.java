// save this program as Excep8.java

class Excep8 {

  public static void main(String args[]) {

    int result = 5;
    int test = 0;
    
	int list[] = new int[3];
   

   try{
   
   result = result/test;
   
   list[21] = 99;

   

    }//try block

     catch(ArithmeticException errmsg)
    {

    // this will be more specific than the first catch statement on line 14
    System.out.println("Division by zero is undefined !!!" + errmsg.toString());

    }//catch

     catch(Exception errmsg)
    {

    System.out.println("This is the catch-all in the Exception class " + errmsg);

    }//catch


  }// main

}// class Excep8
