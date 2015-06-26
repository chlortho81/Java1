// save this file as Emp_Ex13.java
import java.text.*;

class Emprec {
  String name;
  double hours;
  double rate;

  
 Emprec() {} // this is the default constructor !!!!


  
  
Emprec(String name)
{

this.name = name;

}// constructor






Emprec(String name, double hours, double rate)
{

this.name = name;

this.hours = hours;

this.rate = rate;
 System.out.println(" \t\t\t  this is the string double double constructor" );
}// constructor


Emprec(String name, float hours, float rate)
{

this.name = name;

this.hours = hours;

this.rate = rate;
 System.out.println(" \t\t\t  this is the string float float constructor" );
}// constructor

double calc_gross_pay()
{

   return (hours * rate);

}// calc_gross_pay


double calc_fed_tax(double h, double r)
{

  double yearly_income;

  yearly_income = h * r *52;

   if (yearly_income < 30000.00) return (h * r *.28);

   else if ( yearly_income < 50000.00 ) return (h * r* .32);

   else return (h * r * .38);


}// calc_fed_tax


double calc_state_tax(double h, double r)
{

  double state_tax;

  state_tax = h * r * .0561;

  return (state_tax);

}// calc_state_tax


}// Emprec

// This class declares an object of type Emprec.

class Emp_Ex13 {

   public static void main(String args[]) {

    Emprec employee = new Emprec("Mary Smith",45,12);

   Emprec employee2 = new Emprec();

    double employee_gross_pay;

    double employee_fed_tax;

    // Let's assign values to both employee's objects
    // this code will now be repalced with a constructor
/*
    employee.name = " Mary Smith ";
    employee.hours = 40;
    employee.rate = 15.00;


    employee2.name = " Butch Barkley ";
    employee2.hours = 3;
    employee2.rate = 6.25;

*/

    // let's display the output for employee first
    System.out.print(" The gross salary for " + employee.name );

    employee_gross_pay = employee.calc_gross_pay();

    employee_fed_tax = employee.calc_fed_tax(employee.hours, employee.rate);

    System.out.printf("\n THE GROSS PAY is %6.2f",employee_gross_pay);

    System.out.println(" the federal income tax is " + employee_fed_tax);

    System.out.println(" the state income tax is " + employee.calc_state_tax(employee.hours, employee.rate));

    // now let's print the output for employee2

    System.out.print(" The gross salary for " + employee2.name );

    employee_gross_pay = employee2.calc_gross_pay();

    System.out.println(" is " + employee_gross_pay);

    employee_fed_tax = employee2.calc_fed_tax(employee2.hours, employee2.rate);

    System.out.println(" the federal income tax is " + employee_fed_tax);


    System.out.println(" the state income tax is " + employee2.calc_state_tax(employee.hours, employee.rate));


  // now let's see if employee2 can be made to be a reference

  employee2 = employee;

  // let's redisplay the data for employee2
  // remember if it is now a reference for employee
  // it will display employee's data.

    // now let's print the output for  employee2
    // which is now a reference for employee

    System.out.print(" The gross salary for " + employee2.name );


    employee_gross_pay = employee2.calc_gross_pay();


    System.out.println(" is " + employee_gross_pay);

    employee_fed_tax = employee2.calc_fed_tax(employee2.hours, employee2.rate);

    System.out.println(" the federal income tax is " + employee_fed_tax);

    System.out.println(" the state income tax is " + employee2.calc_state_tax(employee.hours, employee.rate));


  }//main

}// Emp_Ex13

