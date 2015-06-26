// save this file as Inherit4.java

class CD {
double interest_rate;
protected int months;

public int X ()
{
months = 10;
return months;
}

}//class CD

class Customer extends CD {

String name;
String address;
double deposit;


public int X ()
{
months = 20;
return months;
}

}// class Customer

class InheritTest {

public static void main(String args[])

{

// let's create the object first

Customer person = new Customer();

// now we will load it with data
//person.months = 5;
//System.out.println("\n Here is the value of person.months "+person.months);
person.X();
System.out.println("\n Here is the value of person.months after method X()  "+person.X());
}//main

}//class Inherit3


