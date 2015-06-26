// save this file as Emp_Ex11.java
// we will now look at references

class Emprec {
  String name;
  double hours;
  double rate;
}

// This class declares an object of type Emprec.

class Emp_Ex11 {

   public static void main(String args[]) {

    Emprec employee = new Emprec();

    Emprec empref;  // this is a reference to any object
                    // of type Emprec


    double employee_gross_pay;

    // Let's assign values to employee's instance variables

    employee.name = " Mary Smith ";
    employee.hours = 40;
    employee.rate = 15.00;

    // Let's compute the gross salary for this employee

    employee_gross_pay = employee.hours * employee.rate;

    // now let's print the output for this employee

    System.out.print(" The gross salary for " + employee.name );

    System.out.println(" is  " + employee_gross_pay );

    // now watch what happens when we use the reference
    empref = employee;
    // let's once again display the output using the reference

    System.out.println(" The gross salary for " + empref.name );
    System.out.println(" when he/she has worked " + empref.hours);
    System.out.println(" hours and the employee's rate of pay is " + empref.rate);
    System.out.println(" dollars an hour is  " + employee_gross_pay );

   // can the reference now change the data and effect employee ?????

    empref.name = " Sally Jones ";
    empref.hours = 45;
    empref.rate = 12.00;

    // let's redisplay using employee

    // Let's compute the gross salary for this employee

    employee_gross_pay = employee.hours * employee.rate;

    // now let's print the output for this employee

    System.out.print(" The gross salary for " + employee.name );

    System.out.println(" is  " + employee_gross_pay );

    // now watch what happens when we use the reference
   // empref = employee;   // already assigned to employee 
    // let's once again display the output using the reference

    System.out.println(" The gross salary for " + empref.name );
    System.out.println(" when he/she has worked " + empref.hours);
    System.out.println(" hours and the employee's rate of pay is " + empref.rate);
    System.out.println(" dollars an hour is  " + employee_gross_pay );

   empref = new Emprec();

    empref.name = " Fred Turner ";
    empref.hours = 22;
    empref.rate = 10.00;

    // now let's redisplay the output
    // but first let's recalculate the gross pay

    employee_gross_pay = empref.hours * empref.rate;

    System.out.println(" The gross salary for " + empref.name );
    System.out.println(" when he/she has worked " + empref.hours);
    System.out.println(" hours and the employee's rate of pay is " + empref.rate);
    System.out.println(" dollars an hour is  " + employee_gross_pay );

   // how about the employee object has that also bee changed ?
   // first let's calculate the gross pay again 
    employee_gross_pay = employee.hours * employee.rate;
    System.out.println(" The gross salary for " + employee.name );
    System.out.println(" when he/she has worked " + employee.hours);
    System.out.println(" hours and the employee's rate of pay is " + employee.rate);
    System.out.println(" dollars an hour is  " + employee_gross_pay );


  }//main

}// Emp_Ex11


