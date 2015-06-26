
  import java.io.*;
  import java.awt.*;
  import java.awt.event.*;
  import java.text.DecimalFormat;
  import java.util.*;


  class Record {

  protected int employeeNumber;
  protected String name;
  protected String ssNumber;
  protected String childName;
  protected String childSSNumber;
  protected double hours;
  protected double rate;


  public void read (RandomAccessFile file ) throws IOException {

  employeeNumber = file.readInt();

  char fullname [] = new char [20];
  for (int i =0; i <fullname.length; i++)
     fullname[i] = file.readChar();
  name = new String (fullname);

  char socsec [] = new char [20];
  for (int i =0; i <socsec.length; i++)
     socsec[i] = file.readChar();
  ssNumber= new String (socsec);

  char kidname [] = new char [20];
  for (int i =0; i <kidname.length; i++)
     kidname[i] = file.readChar();
  childName = new String (kidname);

  char kidSS [] = new char [20];
  for (int i =0; i <kidSS.length; i++)
     kidSS[i] = file.readChar();
  childSSNumber = new String (kidSS);

  hours = file.readDouble();

  rate = file.readDouble();





  }

  public void write (RandomAccessFile file) throws IOException  {

  StringBuffer buffer;


  file.writeInt (employeeNumber);

  if (name != null)
     buffer = new StringBuffer (name);
  else
     buffer = new StringBuffer(20);
     buffer.setLength(20);
  file.writeChars(buffer.toString());

  if (ssNumber != null)
     buffer = new StringBuffer (ssNumber);
  else
     buffer = new StringBuffer(20);
     buffer.setLength(20);
  file.writeChars(buffer.toString());

  if (childName != null)
     buffer = new StringBuffer (childName);
  else
     buffer = new StringBuffer(20);
     buffer.setLength(20);
  file.writeChars(buffer.toString());

  if (childSSNumber != null)
     buffer = new StringBuffer (childSSNumber);
  else
     buffer = new StringBuffer(20);
     buffer.setLength(20);
  file.writeChars(buffer.toString());

  file.writeDouble (hours);

  file.writeDouble (rate);





  }

  public void setemployeeNumber(int employeeNumber)
     { 
     this.employeeNumber = employeeNumber;
     }

  public int getemployeeNumber() 
     {
      return employeeNumber;
     }

  public void setname(String name)
     { 
     this.name = name;
     }

  public String getname()
     {
      return name;
     }

  public void setssNumber(String ssNumber)
     { 
     this.ssNumber = ssNumber;
     }

  public String getssNumber() 
     {
      return ssNumber;
     }


  public void setchildName(String childName)
     { 
     this.childName = childName;
     }

  public String getchildName() 
     {
      return childName;
     }

  public void setchildSSNumber(String childSSNumber)
     { 
     this.childSSNumber = childSSNumber;
     }

  public String getchildSSNumber() 
     {
      return childSSNumber;
     }

  public void sethours(double hours)
     { 
     this.hours = hours;
     }

  public double gethours() 
     {
      return hours;
     }

  public void setrate(double rate)
     { 
     this.rate = rate;
     }

  public double getrate() 
     {
      return rate;
     }


  public static int record_size() 
     {
     return 180;
     }





  }




  public class ReadRandomPayrollList extends Frame
     implements ActionListener {

  private TextField employeeNumberField,nameField,ssNumberField,
  childNameField,childSSNumberField,
     hoursField,rateField;

  private Button Read_Record, // send record from file
     End;  // end of data entry

  private RandomAccessFile input; // file for output

  Record new_entry;

  public ReadRandomPayrollList()
  {
  super ("Read company payroll file" );

  new_entry = new Record();

  try {
  input = new RandomAccessFile ("copayroll.dat", "rw");
  } // end of try

  catch (IOException e) {
  System.err.println (e.toString());
  System.exit (1);
  } // close catch

  setSize (300, 350);

  setLayout (new GridLayout (8,2));

  setFont( new Font("SansSerif", Font.BOLD,12));

  add (new Label ("Employee Number"));
     employeeNumberField = new TextField();
     employeeNumberField.setEditable(false);
     add (employeeNumberField);

  add (new Label ("Employee Name"));
     nameField = new TextField();
     nameField.setEditable(false);
     add (nameField);

  add (new Label ("Employee SS Number"));
     ssNumberField = new TextField();
     ssNumberField.setEditable(false);
     add (ssNumberField);

  add (new Label ("Child's Name"));
     childNameField = new TextField();
     childNameField.setEditable(false);
     add (childNameField);

  add (new Label ("Child's SS Number"));
     childSSNumberField = new TextField();
     childSSNumberField.setEditable(false);
     add (childSSNumberField);

  add (new Label ("Employee's Hours"));
     hoursField = new TextField();
     hoursField.setEditable(false);
     add (hoursField);

  add (new Label ("Employee's Pay Rate"));
     rateField = new TextField();
     rateField.setEditable(false);
     add (rateField);

  Read_Record = new Button ("Read New Entry");
     Read_Record.addActionListener(this);
     add (Read_Record);

  End = new Button ("End of Data Entry");
     End.addActionListener(this);
     add (End);

  setVisible(true);

  }// end of setting frame

  public void actionPerformed (ActionEvent e)


  {
  if (e.getSource() == Read_Record) 
     ReadPayrollRecord();

  else

  closeFile();
  }

  public void ReadPayrollRecord()

  {
  DecimalFormat twoDigits = new DecimalFormat("$.00");

  try {
  do {
  new_entry.read(input);
  } 
  while (new_entry.getemployeeNumber() == 0);

  employeeNumberField.setText(String.valueOf(new_entry.getemployeeNumber()));
  nameField.setText(new_entry.getname());
  ssNumberField.setText(new_entry.getssNumber());
  childNameField.setText(new_entry.getchildName());
  childSSNumberField.setText(new_entry.getchildSSNumber());
  hoursField.setText(String.valueOf(new_entry.gethours()));
  rateField.setText(String.valueOf(twoDigits.format(new_entry.getrate())));

  LinkedList Employee_Record = new LinkedList();

  Employee_Record.add(String.valueOf(new_entry.getemployeeNumber()));
  Employee_Record.add(new_entry.getname());
  Employee_Record.add(new_entry.getssNumber());
  Employee_Record.add(new_entry.getchildName());
  Employee_Record.add(new_entry.getchildSSNumber());
  Employee_Record.add(String.valueOf(new_entry.gethours()));
  Employee_Record.add(String.valueOf(twoDigits.format(new_entry.getrate())));

  System.out.println("Contents of Employee_Record: "+Employee_Record);


  }

  catch (EOFException eof) {

  closeFile ();
  }

  catch (IOException e) {
     System.err.println ("File read Error ");
     System.exit (1);
  }
  }

  void closeFile()
  {
  try {
  input.close();
  System.exit (0);

  }
  catch (IOException e) {
  System.err.println ( "File close error " );
  System.exit (1);
  }
  }

  public static void main (String args[])

  {



  new ReadRandomPayrollList ();

  }
  }