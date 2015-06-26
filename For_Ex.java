// call this file For_Ex.java

class For_Ex {

  public static void main(String args[]) {

  int i;
  int sum = 0;
  
  
    for( i = 0; i<=4; ++i)
             sum += i;

   

   float ave = ((float)sum / (float)--i);
	
	System.out.println(ave);
	
	i=5;
	System.out.println(--i);
	
	i=5;
	System.out.println(i--);

  }//main

}// ForEx

