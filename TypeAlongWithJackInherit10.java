// save this file as Inherit10.java
import javax.swing.JOptionPane;
import java.text.*;

class CD {
double interest_rate;
int months;

CD(){
interest_rate = 0.00;
months = 0;
}//CD()

CD(double interest_rate,int months)
{
this.interest_rate =interest_rate;
this.months = months;
}//CD

double calc_interest()
{

// we will use the simple formula I = P * R * T;

//System.out.println(" the amount of interest earned is " + (deposit *  interest_rate * months/12));

return (1000.00);

}//calc_interest
public  String toString() {

return("\n the rate of interest on the CD is  " + this.interest_rate + "percent"+
"\n the number of months the principal is deposited for is  " + this.months);

}//toString()
}//class CD
//===================================
class Customer extends CD {
String name;
String address;
double deposit;


// what we will set up here a default constructor
//Customer(){super();}

Customer()
{
super();
name = "Not Entered";
address = "Not available";
deposit = 0.00;
//interest_rate = 0.00;
//months = 0;

} //Customer


Customer(String name,String address,double deposit,double interest_rate,int months)
{
 
super(interest_rate,months);
this.name = name;
this.address = address;
this.deposit = deposit;
//this.interest_rate = interest_rate;
//this.months = months;

} //Customer



double calc_interest()
{

// we will use the simple formula I = P * R * T;

//System.out.println(" the amount of interest earned is " + (deposit *  interest_rate * months/12));

return (deposit * interest_rate * months/12.0);

}//calc_interest

public  String toString() {
 NumberFormat fmt = NumberFormat.getCurrencyInstance();
 
return(" \ncustomer's name " + this.name+
"\n customer's address " + this.address+
" \ncustomer's initial deposit " + fmt.format(this.deposit)+
super.toString()+
"\nthe total interest is " + fmt.format(this.calc_interest())+
"This is CD's calc_interest "+ fmt.format(super.calc_interest()));

}//toString()

}// class Customer

class TypeAlongWithJackInherit10 {

public static void main(String args[])

{

// let's create the object first
// notice we are now using the new constructor
//Customer person = new Customer();
Customer person = new Customer("Carlos T. Bayer","23 Blueberry Circle",1234.56,.05,12);
//Customer person_ref;// this is a reference
CD person_ref;// this is now a reference to the class CD
double total_interest;

// we will now assign the reference

person_ref = person; // person_ref is now an alias for person



/*
System.out.println(" customer's name " + person.name);
System.out.println(" customer's address" + person.address);
System.out.println(" customer's initial deposit" + person.deposit);

// we can now display the following data
System.out.println(" the rate of interest on the CD is  " + person_ref.interest_rate + "percent");
System.out.println(" the number of months the principal is deposited for is  " + person_ref.months);
// we can now display the total interest earned
*/
total_interest = person.calc_interest();
//System.out.println(" the total interest on the deposited amount is " + total_interest);

System.out.println(person);

JOptionPane.showMessageDialog(null,
                "Customer Information:" +
                person.toString(),
                "Employee Payroll Being Processed",
                JOptionPane.PLAIN_MESSAGE );

}//main

}//class Inherit10


