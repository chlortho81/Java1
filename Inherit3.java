// save this file as Inherit3.java

class CD {
double interest_rate;
int months;

void calc_interest()
{


System.out.println(" HERE IS SUPER MAKING THE CALL TO THE BASE CLASS  CD !!! ");


}//calc_interest
}//class CD

class Customer extends CD {


String name;
String address;
double deposit;
String socsec;


void x(){
super.calc_interest();
}



void calc_interest()
{

// we will use the simple formula I = P * R * T;

System.out.println(" the amount of interest earned is " + ( months/12.0 * deposit *  interest_rate ));

System.out.println(" \n I am using the calc_interest found in class Customer");

}//calc_interest


}// class Customer

class Inherit3 {

public static void main(String args[])

{

// let's create the object first

Customer person = new Customer();

// now we will load it with data

person.name = "Michael T. Bayer";
person.address = "6626 Rue Drive";
person.deposit = 4456.06;
person.socsec = "123-45-6789";

// we can now load the following fields
person.interest_rate = .05;
person.months = 21;

// let us now display the data

System.out.println(" customer's name " + person.name);
System.out.println(" customer's address" + person.address);
System.out.println(" customer's initial deposit" + person.deposit);
System.out.println(" customer's socsec is" + person.socsec);
// we can now display the following data
System.out.println(" the rate of interest on the CD is  " + person.interest_rate + "percent");
System.out.println(" the number of months the principal is deposited for is  " + person.months);
// we can now display the total interest earned

person.calc_interest();
person.x();

}//main

}//class Inherit3















