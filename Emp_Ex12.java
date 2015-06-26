// save this file as Emp_Ex12.java
// Now we will look at constructors !!!!!!!!!

class Emprec {
  String name;
  double hours;
  double rate;

 Emprec() {} // default constructor !!!!

 Emprec(String name, double hours, double rate)
{

this.name = name;

this.hours = hours;

this.rate = rate;
 
System.out.println(" \t\t\t  this is the string double double constructor" );

}// constructor




double calc_gross_pay()
{

   return (this.hours * this.rate);

}// calc_gross_pay


double calc_fed_tax(double hours, double rate)
{

  double yearly_income;

  yearly_income = hours * rate *52;

   if (yearly_income < 30000.00) return (hours * rate *.28);

   else if ( yearly_income < 50000.00 ) return (hours * rate * .32);

   else return (hours * rate * .38);


}// calc_fed_tax


double calc_state_tax(double hours, double rate)
{

  double state_tax;

  state_tax = hours * rate * .0561;

  return (state_tax);

}// calc_state_tax


}// Emprec

// This class declares an object of type Emprec

class Emp_Ex12 {

   public static void main(String args[]) {

    Emprec employee = new Emprec("Mary Smith",40.0,15.00);

    
	Emprec employee2 = new Emprec("Butch Barkley",3,6.25);
	
	Emprec X =new Emprec();
    
	double employee_gross_pay;

    double employee_fed_tax;

    // Let's assign values to both employee's objects
    // this code will now be replaced with a constructor
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

    System.out.println(" is " + employee_gross_pay);

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

}// Emp_Ex12

