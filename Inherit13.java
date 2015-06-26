// save this file as Inherit13.java

// CD is now an abstract class
// it cannot have any object because it it as yet unfinished, incomplete
// however, it can have a reference

abstract class CD {
double interest_rate;
int months;
abstract double calc_interest();// this method is not finished !!!
}//class CD

class Customer extends CD {

String name;
String address;
double deposit;


double calc_interest()
{

// we will use the simple formula I = P * R * T;

//System.out.println(" the amount of interest earned is " + (deposit *  interest_rate * months/12));

return (deposit * interest_rate * months/12.0);

}//calc_interest

}// class Customer

class Inherit13 {

public static void main(String args[])

{

// let's create the object first

Customer person = new Customer();
//Customer person_ref;// this is a reference
CD person_ref;// this is now a reference to the class CD
double total_interest;

// we will now assign the reference

person_ref = person; // person_ref is now an alias for person

// now we will load it with data

person.name = "Michael T. Bayer";
person.address = "6626 Rue Drive";
person.deposit = 4456.06;

// we can now load the following fields
person_ref.interest_rate = .05;
person_ref.months = 12;

// let us now display the data

System.out.println(" customer's name " + person.name);
System.out.println(" customer's address" + person.address);
System.out.println(" customer's initial deposit" + person.deposit);

// we can now display the following data
System.out.println(" the rate of interest on the CD is  " + person_ref.interest_rate + "percent");
System.out.println(" the number of months the principal is deposited for is  " + person_ref.months);
// we can now display the total interest earned

total_interest = person_ref.calc_interest();
System.out.println(" the total interest on the deposited amount is " + total_interest);

}//main

}//class Inherit13


