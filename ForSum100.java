
class ForSum100 {
  

  public static void main(String args[]) {
   
   for(int i=1,sum=0; i <= 100; i++) {

                sum += i;
 System.out.println("For Loop Sum = " + sum); // sum is a local variable and need to be in this scope				
        }//for

   //System.out.println("For Loop Sum = " + sum);  // this won't work as sum is a local variable (see above)
  }
}
