// save this file as Emp_Ex2.java

class Emprec {
  String name;
  double hours;
  double rate;

void change()
{
name = "Fred";
hours = -222;
rate =55.66;
   

}// change()


void change(String name,double hours,double rate)
{
name = "Fred";
hours = -222;
rate =55.66;
   

}// change()


void change(Emprec x)
{
x.name = "Fred";
x.hours = -222;
x.rate =55.66;
   

}// change()






}// Emprec

// This class declares an object of type Emprec

class Emp_Ex2 {

   public static void main(String args[]) {

    Emprec employee = new Emprec();
   

    // Let's assign values to both employee's fields

    employee.name = " Mary Smith ";
    employee.hours = 40;
    employee.rate = 15.00;

//Now let's write out the data !!!!
  System.out.println("name "+ employee.name);
	
System.out.println("hours "+ employee.hours);
System.out.println("rate "+ employee.rate);

//employee.change();
//employee.change(employee.name,employee.hours,employee.rate);
employee.change(employee);
//Now let's write out the data after I ran the method change  !!!!
  System.out.println("name "+employee.name);
	
System.out.println("hours "+ employee.hours);
System.out.println("rate "+ employee.rate);

 }//main

}// Emp_Ex2

