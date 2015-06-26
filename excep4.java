// save this program as Excep4.java

class Excep4 {

  public static void main(String args[]) {

    int result = 5;
    int test = 0;
   
   try{

    result = result/test;

    }
    

	 catch(ArrayIndexOutOfBoundsException errmsg)
    {

    System.out.println("Division by zero is undefined !!!" + errmsg);

    }//catch

	catch(ArithmeticException errmsg)
    {

    System.out.println("This exception is being handled \n by the ArithmeticException class `" + errmsg);

    }//catch
	
	
	
	catch(Exception errmsg)
    {

    System.out.println("This exception is being handled \n by the Exception class `" + errmsg);

    }//catch

  
 
  }// main

}// class Excep4
