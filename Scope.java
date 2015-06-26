
class Scope {
  public static void main(String args[]) {
    int x; // known to all code within main
int y;
    x = 10;
    if(x == 10)  { // start new scope
      
	
	   y = 20; // known only to this block

      // x and y both known here.
      System.out.println("x and y: " + x + " " + y);
      x = y * 2;
    }//if
  y = 100; // Error! y not known here 

    // x is still known here.
    System.out.println("x is " + x);
	 System.out.println("y is " + y);
  }
}

