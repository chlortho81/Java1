// save this program as Excep3.java

class Excep3 {

  public static void main(String args[]) {

    int result = 5;
    int test = 0;
	
    try{

    result = result/test;

    }
     catch(Exception errmsg)
    {

    System.out.println("This is the error " + errmsg);

    }//catch



  }// main

}// class Excep3
