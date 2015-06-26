// HERE IS THE CUSTOMER.JAVA FILE NEEDED FOR HW 1 OF ADVANCED JAVA PROGRAMMING !!!!

 import javax.swing.JOptionPane;





 public class Customer{




 public static void main ( String args[ ] )

 {



 String name;

 String fWeek;

 String firstInvoice,

secondInvoice,

 thirdInvoice,

fourthInvoice,

 fifthInvoice;

 int Week;

 double number1,

 number2,

 number3,

 number4,

 number5,

 sum;

 double average;





 name = JOptionPane.showInputDialog("Enter the Customer's Name");

 fWeek = JOptionPane.showInputDialog("Enter the number of the week in the month ");

 firstInvoice = JOptionPane.showInputDialog("Enter the Invoice amount ");

 secondInvoice = JOptionPane.showInputDialog("Enter the Second Invoice amount ");

 thirdInvoice = JOptionPane.showInputDialog("Enter the Third Invoice amount ");

 fourthInvoice = JOptionPane.showInputDialog("Enter the Fourth Invoice amount ");

 fifthInvoice = JOptionPane.showInputDialog("Enter the Fifth Invoice amount ");



 Week = Integer.parseInt(fWeek);

 number1 = Double.parseDouble(firstInvoice);

 number2 = Double.parseDouble(secondInvoice);

 number3 = Double.parseDouble(thirdInvoice);

 number4 = Double.parseDouble(fourthInvoice);

 number5 = Double.parseDouble(fifthInvoice);



 sum = number1 + number2 + number3 + number4 + number5;



 

 

 



 average = sum / 5.00;



 JOptionPane.showMessageDialog(null, "Customer name is " + name + "\n Week of the month is " + Week +

 "\n The Total for the Week is " + sum +

 "\n The average invoice is " + average ,

 "Results",JOptionPane.PLAIN_MESSAGE );





System.exit(0);



 }// end main

 } //end class