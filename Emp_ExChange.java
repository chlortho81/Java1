// save this file as Emp_ExChange.java

class Emprec {
  String name;
  double hours;
  double rate;

void change(String name, double hours,double rate)
{
this.name = "Fred";
this.hours = -222;
this.rate =55.66;
   

}// calc_gross_pay


}// Emprec

// This class declares an object of type Emprec

class Emp_ExChange {

   public static void main(String args[]) {

    Emprec employee = new Emprec();
   

    // Let's assign values to both employee's objects

    employee.name = " Mary Smith ";
    employee.hours = 40;
    employee.rate = 15.00;

employee.change(employee.name, employee.hours, employee.rate);
   
   System.out.println("name "+employee.name);
	
System.out.println("hours "+employee.hours);
System.out.println("rate "+employee.rate);


   





  }//main

}// Emp_Ex2

