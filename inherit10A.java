// save this file as Inherit10A.java

class CD {
double interest_rate;
int months;

CD ()
{
interest_rate = 0.00;
months = 0;
}//CD



CD(double interest_rate,int months)
{

this.interest_rate = interest_rate;
this.months = months;

}//CD
public String toString()
{
return ("\n your interest rate is "+interest_rate+
"\n the number of months is "+ months);




}//toString()
}//CD


class Customer extends CD {
String name;
String address;
double deposit;
double finalValue;

// what we will set up here a default constructor

Customer()
{
super();

name = "Not Entered";
address = "Not available";
deposit = 0.00;
finalValue = calc_interest();
} //Customer


Customer(String name,String address,double deposit,double interest_rate,int months)
{

super(interest_rate,months);


this.name = name;
this.address = address;
this.deposit = deposit;
finalValue = calc_interest();

} //Customer



double calc_interest()
{

// we will use the simple formula I = P * R * T;

//System.out.println(" the amount of interest earned is " + (deposit *  interest_rate * months/12));

return (deposit * interest_rate * months/12.0);

}//calc_interest

public String toString()
{
return ("\n your name is "+name+
"\n your address is "+ address+
"\n your deposit is "+deposit+super.toString()+
"\n your final value is "+finalValue);







}//toString()
}// class Customer

class Inherit10A {

public static void main(String args[])

{

// let's create the object first
// notice we are now using the new constructor

Customer person = new Customer("Carlos T. Bayer","23 Blueberry Circle",1234.56,.05,12);
//Customer person_ref;// this is a reference
CD person_ref;// this is now a reference to the class CD
double total_interest;

// we will now assign the reference

person_ref = person; // person_ref is now an alias for person



System.out.println(person);

}//main

}//class Inherit10A


