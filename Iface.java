// save this file as Iface.java


// notice that the access here is default
// had it been public then the method's
// access would also be public

interface CD_Iface {

// there may never be any default implementation
// of any method found in an interface !!!

// this is an abstract method and
// must be defined by the implementing class

  double calc_interest();
  //	 double calc_interest2();
//double cc() {return 100.0;}

}//class CD_Iface

//===================================================

class CD {
double interest_rate;
int months;

}//class CD

class Customer extends CD implements CD_Iface{
String name;
String address;
double deposit;


// the implementing class must define the calc_interest method
// or must itself be declared as abstract !!!!

public double calc_interest()
{

// we will use the simple formula I = P * R * T;

//System.out.println(" the amount of interest earned is " + (deposit *  interest_rate * months/12));

return (deposit * interest_rate * months/12);

}//calc_interest


}// class Customer

class Iface {

public static void main(String args[])

{

// let's create the object first

Customer person = new Customer();
CD_Iface X ;
double total_interest;
X = person;
// now we will load it with data

person.name = "Michael T. Bayer";
person.address = "6626 Rue Drive";
person.deposit = 4456.06;

// we can now load the following fields
person.interest_rate = .05;
person.months = 12;

// let us now display the data

System.out.println(" customer's name " + person.name);
System.out.println(" customer's address" + person.address);
System.out.println(" customer's initial deposit" + person.deposit);

// we can now display the following data
System.out.println(" the rate of interest on the CD is  " + person.interest_rate + "percent");
System.out.println(" the number of months the principal is deposited for is  " + person.months);
// we can now display the total interest earned

total_interest = X.calc_interest();
System.out.println(" the total interest on the deposited amount is " + total_interest);

}//main

}//class Iface


