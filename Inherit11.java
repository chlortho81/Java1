// save this file as Inherit11.java

final class CD {
double interest_rate;
int months;

// here are the constructors !!!

CD()
{
interest_rate = 0.00;
months = 0;

}// constructor

CD(double interest_rate,int months)
{

this.interest_rate = interest_rate;

this.months = months;

}// CD constructor


}//class CD

class Customer extends CD {

 String name;
String address;
double deposit;
//double finalamount;

// what we will set up here a default constructor

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

// as we will discuss super must be called first.

super(interest_rate,months);

this.name = name;
this.address = address;
this.deposit = deposit;

// notice that these fields ar now commented out here !!!

//this.interest_rate = interest_rate;
//this.months = months;

} //Customer



double calc_interest()
{

// we will use the simple formula I = P * R * T;

//System.out.println(" the amount of interest earned is " + (deposit *  interest_rate * months/12));

return (deposit * interest_rate * months/12.0);

}//calc_interest


}// class Customer

class Inherit11 {

public static void main(String args[])

{

// let's create the object first
// notice we are now using the new constructor

//  Customer person = new Customer();

//Customer person = new Customer();
Customer person = new Customer("Carlos T. Bayer","23 Blueberry Circle",1234.56,.05,12);

//Customer person_ref;// this is a reference
CD person_ref;// this is now a reference to the class CD
double total_interest;

// we will now assign the reference

person_ref = person; // person_ref is now an alias for person

// now we will load it with data

//person.name = "Michael T. Bayer";
//person.address = "6626 Rue Drive";
//person.deposit = 4456.06;

// we can now load the following fields
//person_ref.interest_rate = .05;
//person_ref.months = 12;

// let us now display the data

System.out.println(" customer's name " + person.name);
System.out.println(" customer's address" + person.address);
System.out.println(" customer's initial deposit" + person.deposit);

// we can now display the following data
System.out.println(" the rate of interest on the CD is  " + person_ref.interest_rate + "percent");
System.out.println(" the number of months the principal is deposited for is  " + person_ref.months);
// we can now display the total interest earned

total_interest = person.calc_interest();
System.out.println(" the total interest on the deposited amount is " + total_interest);

}//main

}//class Inherit11


