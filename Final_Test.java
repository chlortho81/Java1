// Final Program  date: 6/6/1999
// By: Carlos A. Schulze
// Java Programming - Boston

import java.io.*;

abstract class CD {
double interest_rate;
int months;
abstract double calc_interest();// this method is not finished !!!
}//class CD

class Customer extends CD {

double deposit;

Customer (double deposit,double interest_rate,int months){
        this.deposit = deposit;
        this.interest_rate = interest_rate;
        this.months = months;
}// end of customer

double calc_interest()
{

// we will use the simple formula I = P * R * T;


return (deposit * interest_rate * months/12);

}//calc_interest


}// class Customer


//_______________________________________ X __________________________________________________________


class Final_Test {
  public static void main(String args[]) 
  throws IOException
  {
    Customer myCustomer;
    
   // BufferedReader indata = new BufferedReader( new InputStreamReader(System.in));
        DataInputStream indata = new DataInputStream(System.in);
   
      String str1, str2, str3,str4,str5,Name,Address;
    
     int months;
   
     double deposit, interest_rate;
     
	 System.out.println (" Enter client and interest information (Enter -1 in months to exit) : ");
    do {

    try {    
    
       
       str1 = indata.readLine();
           
       str2 = indata.readLine();
        
       str3 = indata.readLine();
         
       str4 = indata.readLine();   
       str5 = indata.readLine();
          
          Name = str1;

          Address = str2;

          deposit =  Double.valueOf(str3).doubleValue();

          interest_rate = Double.valueOf(str4).doubleValue();
           
          months = Integer.parseInt(str5);        
          if (months == -1) System.exit(0);
          
       }
     catch (NumberFormatException e) {
        System.err.println("Invalid entry entered" +e); 
        deposit = 0.0; interest_rate = 0.0; months = 0;
        Name = ""; Address = "";
    }
     
    

    myCustomer = new Customer(deposit,interest_rate,months);

  

    System.out.println("The name of the client is : " + Name);
    System.out.println("The address of the client is : " + Address);
    System.out.println("The deposit amount is : " + deposit);
    System.out.println("The time of interest is :" + months + " months");
    System.out.println("The current interest is : " + interest_rate);
    System.out.println("The Interest of this account is : " +  myCustomer.calc_interest());
	System.out.println (" ");

   }while (months != -1);
    
  }
}
