// save this file as Emp_Ex8.java

class Emprec {
  String name;
  double hours;
  double rate;

void calc_gross_pay()
{

   System.out.println(" The gross salary is " + (hours * rate) );

}// calc_gross_pay


}// Emprec

// This class declares an object of type Emprec

class Emp_Ex8 {

   public static void main(String args[]) {

    Emprec employee = new Emprec();
    Emprec employee2 = new Emprec();
    double employee_gross_pay;

    // Let's assign values to both employee's objects

    employee.name = " Mary Smith ";
    employee.hours = 40;
    employee.rate = 15.00;


    employee2.name = " Butch Barkley ";
    employee2.hours = 3;
    employee2.rate = 6.25;



    // let's display the output for employee first
    System.out.print(" The gross salary for " + employee.name );

    employee.calc_gross_pay();


    // now let's print the output for employee2

    System.out.print(" The gross salary for " + employee2.name );

    employee2.calc_gross_pay();

  // now let's see if employee2 can be made to be a reference

  employee2 = employee;

  // let's redisplay the data for employee2
  // remember if it is now a reference for employee
  // it will display employee's data.

    // now let's print the output for  employee2
    // which is now a reference for employee

    System.out.print(" The gross salary for " + employee2.name );

    employee2.calc_gross_pay();


  }//main

}// Emp_Ex8

