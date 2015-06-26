import java.io.*;
import java.awt.*;
import java.util.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

 public class EmployeeAddWithConfirm {




public static void main ( String args[ ] )  throws IOException {
 



int vvalue=1;

int counter=0;
JOptionPane optionPane;
//PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("employeelst.dat")));

  PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("employeeList.dat",true)));

while (vvalue!=0){

counter++;
String name;
String address;
String socsec;
String hours;
String rate;
String sex;
String age;

String dept_credit;
String active;



name = (String)JOptionPane.showInputDialog("Enter the  Name for Employee #" + counter);
address = (String)JOptionPane.showInputDialog("Enter the address for Employee #" + counter);
socsec =(String) JOptionPane.showInputDialog("Enter the socsec  for Employee #" + counter);
hours=(String)JOptionPane.showInputDialog("Enter the Hours for Employee #" + counter);
rate=(String)JOptionPane.showInputDialog("Enter the Rate for Employee #" + counter);
sex=(String)JOptionPane.showInputDialog("Enter the Sex (either  M or F) for Employee #" + counter);
age=(String)JOptionPane.showInputDialog("Enter the age for Employee #" + counter);
dept_credit=(String)JOptionPane.showInputDialog("Enter the dep_credit for Employee #" + counter);
active=(String)JOptionPane.showInputDialog("Enter if Employee is active (enter true or false) for the Employee #" + counter +  " ");

output.println(name);
output.println(address);
output.println(socsec);
output.println(hours);
output.println(rate);
output.println(sex.charAt(0));
output.println(Integer.parseInt(age));
output.println(dept_credit);

if (active=="True"|| active=="true" || active=="T" || active=="t")
{output.println(active);
}else{
    output.println(active);

}

vvalue=JOptionPane.showConfirmDialog(null, "Last Record?","Is this the Last Record?", JOptionPane.YES_NO_OPTION);

   // Brings up a modal dialog where the number of choices is determin



} 
String info="exit";




output.println(info); 
output.close();
 System.exit(0);


}// end main


}// end Class
