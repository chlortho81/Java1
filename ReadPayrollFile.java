
// This program reads a file sequentially and displays each
// record in text fields.
import java.io.*;
import java.awt.*;
import java.awt.event.*;



class Emprec {
  String name;
  String address;  
  double hours;
  double rate;
  char sex;
  int age;
//boolean active;  //this is extra credit

Emprec(){}

Emprec(String name,String socsec,double h,double r)
{

this.name=name;
address=socsec;
hours=h;
rate=r;

}//Emprec






double calc_fed_tax(double hours,double rate)
{

  double yearly_income;

  yearly_income = hours * rate *52;

   if (yearly_income < 30000.00) return (hours * rate *.28);

   else if ( yearly_income < 50000.00 ) return (hours * rate* .32);

   else return (hours * rate * .38);


}// calc_fed_tax


double calc_gross_pay()
{

   return (hours * rate);

}// calc_gross_pay


double calc_state_tax(double hours, double rate)
{

  double state_tax;

  state_tax = hours * rate * .0561;

  return (state_tax);

}// calc_state_tax




public  String toString()
{

return 
("\n  your name is "+name+
"\n  your socsec is "+address+
"\n  total hours you worked "+hours+
"\n  your payrate "+rate+
"\n your gross pay is "+calc_gross_pay()+
"\n your state tax is "+calc_state_tax( hours, rate));


}//toString


// see if you can get the boolean to load from a text file.
// what's missing ????

//methods !!!!
// constructors !!!
}// Emprec








public class ReadPayrollFile extends Frame
             implements ActionListener {

 
Emprec employee;


   private TextField RecNumberField,  NameField,
                      SocSecField, HoursField,RateField;


  

   private Button next,   // get next record in file
                  done;   // quit program

   // Application other pieces
   private DataInputStream input;

   // Constructor -- initialize the Frame 
   public ReadPayrollFile()
   {
      super( "Read Client File" );

      // Open the file
      try {
         input = new DataInputStream(
                     new FileInputStream( "payroll.dat" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

      setSize( 1024, 780 );
      setLayout( new GridLayout( 6, 2 ) );
     setFont(new Font("verdana",Font.BOLD,36));  

   




               // create the components of the Frame
      add( new Label( "Account Number" ) );
      RecNumberField = new TextField();
        RecNumberField.setEditable( false );
      add( RecNumberField );

      add( new Label( "Name" ) );
       NameField = new TextField( 20 );
         NameField.setEditable( false );
      add(  NameField );      

      add( new Label( "SocSec Number" ) );
       SocSecField = new TextField( 20 ); 
         SocSecField.setEditable( false );      
       add(SocSecField );

      add( new Label( "Hours" ) );
      HoursField = new TextField( 20 );
            HoursField.setEditable( false );
      add( HoursField );

      add( new Label( "Rate" ) );
      RateField = new TextField( 20 );
      RateField.setEditable( false );
      add( RateField );

      next = new Button( "Next" );
      next.addActionListener( this );
      add( next );      

      done = new Button( "Done" );
      done.addActionListener( this );
      add( done );       
 
      setVisible( true );  
	  HoursField.requestFocus();
	 
   }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == next )
         readRecord();
      else
         closeFile();
   }

   public void readRecord()
   {
      int recnumber;
      String name, socsec;
      double h,r;

      // input the values from the file
      try {
         recnumber = input.readInt();
         name = input.readUTF();
         socsec = input.readUTF();
         h = input.readDouble();
         r=input.readDouble();
    
//Finally we make our object !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
employee=new Emprec(name,socsec,h,r);
    
	System.out.println(employee);
       

	   RecNumberField.setText( String.valueOf( recnumber ) );
         NameField.setText( name );
         SocSecField.setText( socsec );
         HoursField.setText( String.valueOf( employee.calc_state_tax(h,r) ) );
            RateField.setText( String.valueOf( employee.calc_gross_pay() ) );

      }
      catch ( EOFException eof ) {
         closeFile();
      }
      catch ( IOException e ) {
         System.err.println( "Error during read from file\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   private void closeFile()
   {
      try {
         input.close();
         System.exit( 0 );
      }
      catch ( IOException e ) {
         System.err.println( "Error closing file\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   public static void main( String args[] )
   {
      new ReadPayrollFile();
   }
}

