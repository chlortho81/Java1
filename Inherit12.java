// save this file as Inherit12.java

class CD {
static String name = "Bank of Wherever ";
double interest_rate;
int months;

public String toString()
{
// note the use of SUPER avoids ambiguity !!
return (" \n\n\n I am in the class CD\n\n\n\n");
}//toString()
}//class CD

class Customer extends CD {
String name;
String address;
double deposit;

void change_name()
{
super.name = "Bank to NOWHERE !!!";

}


public String toString()
{
// note the use of SUPER avoids ambiguity !!
return (" the bank's name is " + super.name +
" the customer's name is " + this.name +
" customer's address" + address + 
" customer's initial deposit" + deposit +
"\n\n\nLET'S HEAR FROM SUPER"+ super.toString()+

// we can now display the following data
" the rate of interest on the CD is  " + interest_rate + "percent" +
" the number of months the principal is deposited for is  " + months);


}// toString

}// class Customer

class Inherit12 {

public static void main(String args[])

{

// let's create the object first

Customer person = new Customer();
Customer person2 = new Customer();

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


// NOW WATCH AND THIS IS REALLY COOL
// I WILL DISPLAY EVERYTHING AT ONCE USING THE
// toString() METHOD I DECLARED IN THE CLASS CUSTOMER
System.out.println(" here goes through the toString() method in the  Customer class ");

System.out.println(person);


//Now let's change the Bank's Name in the class CD !!!!!
person2.change_name();
System.out.println(person);
}//main

}//class Inherit12





