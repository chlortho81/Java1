// save this as Overload_Ex.java

class Overloaded_Methods {

  void methods_have_same_names()
   {

    System.out.println("No parameters here");
   }

  void methods_have_same_names(int x)
   {

    System.out.println("passes in one integer");

  }

 

  void methods_have_same_names(int x, int y)
  {

    System.out.println("passes in 2 integers");

  }
  
  
  
  

  void methods_have_same_names(double d)
   {

    System.out.println("passes in a double");

  }


 
}// Overloaded_Methods
  
class Overload_Ex {

  public static void main(String args[]) {

    Overloaded_Methods object = new Overloaded_Methods();


    object.methods_have_same_names();

    object.methods_have_same_names(20);

    object.methods_have_same_names(5L);

    object.methods_have_same_names(4.5F);

    object.methods_have_same_names(2,4);

    object.methods_have_same_names(6.34);


  }// main

}// Overload_Ex




