// save this program as Excep15.java

class Excep15 {

  public static void main(String args[]) {

    int result = 5;
    int test = 0;
    int list[] = new int[3];
    int i;

    for(i=0;i<16;i++)

    try {

  
 result = 100;
					     try {

						    list[i] = 99;
						  }//try block

						  catch(ArithmeticException errmsg)
							{

							    System.out.println("This is the catch-all in the inner try " + errmsg);

							}//catch
 

	}//try block

     catch(ArrayIndexOutOfBoundsException errmsg)
    {

    System.out.println("This is the catch-all in the outer loop !!!!" + errmsg);

    }//catch


  }// main

}// class Excep15
