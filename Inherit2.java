 // save this file as Inherit2.java

class CD {
double interest_rate;
int months;
}//class CD

class Customer extends CD{


String name;
String address;
double deposit;

}// class Customer

class Inherit2 {

public static void main(String args[])

{

// let's create the object first

Customer person = new Customer();

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
}//main

}//class Inherit2








