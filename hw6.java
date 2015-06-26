// USING THE PARSEEMPSOL.JAVA AS A REFERENCE
// LOAD THIS FROM A FILE AND ALSO PUT THE CONSTRUCTORS
// BACK IN THE 2 CLASSES.

// save this file as Inherit12.java
import java.io.*;


//NOTE: SUBCLASSES CAN NOT INHERIT A SUPERCLASSES' CONSTRUCTOR.



class CD extends Object  {
static String name = "Bank of Wherever ";
double interest_rate;
int months;

//Constructor for class CD

CD(String interest_rate, String months)
  {
   try    {
           
            this.interest_rate=Double.valueOf(interest_rate).doubleValue();
            this.months=Integer.parseInt(months);
          }
   
   catch(NumberFormatException errmsg)
         {
            System.out.println("Invalid format"+errmsg);
            this.interest_rate=0;
         }       

  }    

} 
  
class Customer extends CD {
String cname;
String address;
double deposit;


//Constructor for class Customer.


Customer(String cname,String address,String deposit,String interest_rate,String months)

  {   
     //super(interest_rate,months);
    
 
     try  {  this.cname=cname;
             this.address=address;
             this.deposit=Double.valueOf(deposit).doubleValue();
             //this.interest_rate=Double.valueOf(interest_rate).doubleValue();
             //this.months=Integer.parseInt(months);          


          }

     catch(NumberFormatException errmsg)
          {   System.out.println("Invalid format"+errmsg);
              this.deposit=0;
          }



  } //end of constructor


public String toString()
{
// note the use of SUPER avoids ambiguity !!

return (" the bank's name is " + super.name +
" the customer's name is " + cname +
" customer's address" + address + 
" customer's initial deposit" + deposit +

// we can now display the following data
" the rate of interest on the CD is  " + interest_rate + "percent" +
" the number of months the principal is deposited for is  " + months);


}// toString

}// class Customer

public class hw6 {

public static void main(String args[])

//since constructors can not return a value, need a throws exception here in order to 
//pass the error found within the constructor to the program.This causes the object being
//constructed to be marked for garbage collection.

throws IOException
{

  BufferedReader input=new BufferedReader(new InputStreamReader(System.in));

  String str_person_name;
  String str_person_address;
  String str_person_deposit;
  String str_person_interest_rate;
  String str_person_months;

  int nu=1; 
   for(;;)
    {
      str_person_name=input.readLine();
      str_person_address=input.readLine();
      str_person_deposit=input.readLine();
      str_person_interest_rate=input.readLine();
      str_person_months=input.readLine();

   }

Customer person=new Customer( str_person_name, str_person_address,str_person_deposit, str_person_interest_rate, str_person_months);

// let us now display the data

System.out.println(" customer's name " + str_person_name);
System.out.println(" customer's address" + str_person_address);
System.out.println(" customer's initial deposit" + str_person_deposit);

// we can now display the following data
System.out.println(" the rate of interest on the CD is  " + str_person_interest_rate + "percent");
System.out.println(" the number of months the principal is deposited for is  " + str_person_months);


// NOW WATCH AND THIS IS REALLY COOL
// I WILL DISPLAY EVERYTHING AT ONCE USING THE
// toString() METHOD I DECLARED IN THE CLASS CUSTOMER
System.out.println(" here goes through the toString() method in the  Customer class ");

System.out.println(person);
}//main

}//class hw6







